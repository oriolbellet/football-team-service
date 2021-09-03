package org.oriolbellet.football.team.application.command.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class PlayerAddedToTeamEvent {
    @TargetAggregateIdentifier
    private final UUID teamId;
    private final UUID playerId;
}
