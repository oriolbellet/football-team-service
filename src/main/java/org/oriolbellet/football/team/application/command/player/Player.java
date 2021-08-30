package org.oriolbellet.football.team.application.command.player;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Getter
@ToString
@Aggregate
@NoArgsConstructor // Axon
public class Player {

    @AggregateIdentifier
    private UUID teamId;

    public Player(UUID playerId, String name, String alias, int average) {
        apply(new PlayerCreatedEvent(playerId, name, alias, average));
    }

    @SuppressWarnings("unused") // Axon
    @EventSourcingHandler
    public void on(PlayerCreatedEvent event) {
        teamId = event.getPlayerId();
    }
}
