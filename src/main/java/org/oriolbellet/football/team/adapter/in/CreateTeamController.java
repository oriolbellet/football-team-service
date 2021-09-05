package org.oriolbellet.football.team.adapter.in;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.oriolbellet.football.team.adapter.in.dto.CreateTeamDto;
import org.oriolbellet.football.team.application.command.team.CreateTeamCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/teams/api/v1")
public class CreateTeamController {

    private final CommandGateway commandGateway;

    public CreateTeamController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PutMapping("/{teamId}")
    public void createTeam(@PathVariable("teamId") UUID teamId, @RequestBody CreateTeamDto createTeamDto) {
        commandGateway.send(new CreateTeamCommand(teamId, createTeamDto.getSourceTeamId()));
    }
}

