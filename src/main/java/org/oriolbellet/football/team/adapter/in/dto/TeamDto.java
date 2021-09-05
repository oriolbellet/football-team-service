package org.oriolbellet.football.team.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class TeamDto {
    private final UUID teamId;
    private final String name;
    private final List<PlayerDto> squad;
}
