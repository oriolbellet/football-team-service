package org.oriolbellet.football.team.application.command.lineup;

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
@NoArgsConstructor
public class LineUp {

    @AggregateIdentifier
    private UUID lineUpId;
    //private List<Player> players;
    //private Tactic tactic;

    public LineUp(UUID lineUpId, String tactic) {
        apply(new LineUpCreatedEvent(lineUpId, tactic));
    }

    public void handle(AddPlayerToLineUpCommand cmd) {
        apply(new PlayerAddedToLineUpEvent(cmd.getLineUpId(), cmd.getPlayerId()));
    }

    @SuppressWarnings("unused") // Axon
    @EventSourcingHandler
    public void on(LineUpCreatedEvent event) {
        lineUpId = event.getLineUpId();
        //players = Collections.emptyList();
        //tactic = Tactic.valueOf(event.getTactic());
    }
}
