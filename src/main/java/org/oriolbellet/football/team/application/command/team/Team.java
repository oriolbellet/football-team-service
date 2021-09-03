package org.oriolbellet.football.team.application.command.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.oriolbellet.football.team.application.command.player.PlayerAddedToTeamEvent;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Getter
@Aggregate
@NoArgsConstructor  // Required by Axon
public class Team {

    @AggregateIdentifier
    private UUID teamId;
    private String name;
    private UUID lineUpId;

    public Team(UUID teamId, String name, UUID lineUpId) {
        apply(new TeamCreatedEvent(teamId, name, lineUpId));
    }

    public void handle(AddPlayerToTeamCommand cmd) {
        apply(new PlayerAddedToTeamEvent(cmd.getTeamId(), cmd.getPlayerId()));
    }

    @SuppressWarnings("unused") // Used by Axon
    @EventSourcingHandler
    public void on(TeamCreatedEvent event) {
        teamId = event.getTeamId();
        name = event.getName();
        lineUpId = event.getLineUpId();
    }
}
