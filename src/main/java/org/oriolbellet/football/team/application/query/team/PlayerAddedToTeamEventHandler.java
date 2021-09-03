package org.oriolbellet.football.team.application.query.team;

import org.axonframework.eventhandling.EventHandler;
import org.oriolbellet.football.team.application.command.player.PlayerAddedToTeamEvent;

import javax.inject.Named;

@Named
class PlayerAddedToTeamEventHandler {

    private final TeamProjectionRepository teamProjectionRepository;

    public PlayerAddedToTeamEventHandler(TeamProjectionRepository teamProjectionRepository) {
        this.teamProjectionRepository = teamProjectionRepository;
    }

    @EventHandler
    @SuppressWarnings("unused") // Used by Axon
    public void on(PlayerAddedToTeamEvent event) {
        TeamProjection teamProjection = teamProjectionRepository.findById(event.getTeamId()).orElseThrow(RuntimeException::new);
        teamProjection.addPlayer(event.getPlayerId());
        teamProjectionRepository.save(teamProjection);
    }
}
