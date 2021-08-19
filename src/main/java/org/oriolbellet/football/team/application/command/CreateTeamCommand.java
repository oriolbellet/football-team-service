package org.oriolbellet.football.team.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class CreateTeamCommand {

    @TargetAggregateIdentifier
    private final UUID teamId;

}
