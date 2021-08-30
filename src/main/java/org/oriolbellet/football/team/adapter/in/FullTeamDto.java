package org.oriolbellet.football.team.adapter.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class FullTeamDto {
    private final UUID teamId;
    private final String name;
    private final List<PlayerDto> squad;
}
