package org.oriolbellet.football.team.application.query.team;

import org.axonframework.eventhandling.EventHandler;
import org.oriolbellet.football.team.application.command.team.TeamCreatedEvent;

import javax.inject.Named;
import java.util.Collections;

@Named
class TeamCreatedEventHandler {

    private final TeamProjectionRepository teamProjectionRepository;

    public TeamCreatedEventHandler(TeamProjectionRepository teamProjectionRepository) {
        this.teamProjectionRepository = teamProjectionRepository;
    }

    @EventHandler
    @SuppressWarnings("unused") // Used by Axon
    public void on(TeamCreatedEvent event) {
        TeamProjection teamProjection = new TeamProjection(event.getTeamId(), event.getName(), Collections.emptyList(), event.getLineUpId(), false);
        teamProjectionRepository.save(teamProjection);
    }
}
