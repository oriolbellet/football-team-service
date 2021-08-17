package org.oriolbellet.football.team.application.domain;

import org.axonframework.eventhandling.EventHandler;

import javax.inject.Named;

@Named
public class TeamProjector {

    private final TeamProjectorRepository teamProjectorRepository;

    public TeamProjector(TeamProjectorRepository teamProjectorRepository) {
        this.teamProjectorRepository = teamProjectorRepository;
    }

    @EventHandler
    @SuppressWarnings("unused") // Used by Axon
    public void on(TeamCreatedEvent event) {
        TeamView teamProjector = new TeamView(event.getTeamId());
        teamProjectorRepository.save(teamProjector);
    }
}
