package org.oriolbellet.football.team.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class LineUpDto {
    private final UUID lineUpId;
    private final String tactic;
    private final List<PlayerDto> players;
}
