package org.oriolbellet.football.team.adapter.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeamDto {
    private UUID sourceTeamId;
}