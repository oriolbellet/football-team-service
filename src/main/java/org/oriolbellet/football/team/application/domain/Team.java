package org.oriolbellet.football.team.application.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@NoArgsConstructor  // Required by Axon
@Aggregate
@Getter
public class Team {

    @AggregateIdentifier
    private UUID teamId;

    public Team(UUID teamId) {
        apply(new TeamCreatedEvent(teamId));
    }

    @SuppressWarnings("unused") // Used by Axon
    @EventSourcingHandler
    public void on(TeamCreatedEvent event) {
        teamId = event.getTeamId();
    }

}
