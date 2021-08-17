package org.oriolbellet.football.team.adapter.in;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.oriolbellet.football.team.application.command.CreateTeamCommand;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CreateTeamController {

    private final CommandGateway commandGateway;

    public CreateTeamController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PutMapping
    public void createTeam() {
        commandGateway.send(new CreateTeamCommand(UUID.randomUUID()));
    }

}

