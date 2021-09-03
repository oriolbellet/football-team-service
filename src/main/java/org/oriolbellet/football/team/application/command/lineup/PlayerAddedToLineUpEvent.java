package org.oriolbellet.football.team.application.command.lineup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class PlayerAddedToLineUpEvent {
    @TargetAggregateIdentifier
    private final UUID lineUpId;
    private final UUID playerId;
}
