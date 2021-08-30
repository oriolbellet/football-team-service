package org.oriolbellet.football.team.application.command.lineup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class LineUpCreatedEvent {
    private final UUID lineUpId;
    private final String tactic;
}
