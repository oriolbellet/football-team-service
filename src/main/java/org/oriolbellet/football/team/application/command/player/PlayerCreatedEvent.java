package org.oriolbellet.football.team.application.command.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class PlayerCreatedEvent {
    private final UUID playerId;
    private final String name;
    private final String alias;
    private final int average;
}
