package org.oriolbellet.football.team.adapter.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class TeamDto {
    private final UUID teamId;
    private final String name;
}
