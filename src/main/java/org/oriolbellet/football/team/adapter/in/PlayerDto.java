package org.oriolbellet.football.team.adapter.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class PlayerDto {
    private final UUID playerId;
    private final String alias;
    private final int average;
}
