package org.oriolbellet.football.team.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class TeamNameDto {
    private final UUID teamId;
    private final String name;
}
