package org.oriolbellet.football.team.application.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.Repository;
import org.oriolbellet.football.team.application.domain.Team;

import javax.inject.Named;

@Named
public class CreateTeamCommandHandler {

    private final Repository<Team> teamRepository;

    @SuppressWarnings("all") // Axon bean
    public CreateTeamCommandHandler(Repository<Team> teamRepository) {
        this.teamRepository = teamRepository;
    }

    @CommandHandler
    @SuppressWarnings("unused") // Used by Axon
    public void createTeam(CreateTeamCommand cmd) {
        try {
            teamRepository.newInstance(() -> new Team(cmd.getTeamId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
