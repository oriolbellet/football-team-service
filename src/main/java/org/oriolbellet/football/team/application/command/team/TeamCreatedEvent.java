package org.oriolbellet.football.team.application.command.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class TeamCreatedEvent {
    private final UUID teamId;
    private final String name;
    private final UUID lineUpId;
}
