package org.oriolbellet.football.team.application.query.player;

import org.axonframework.eventhandling.EventHandler;
import org.oriolbellet.football.team.application.command.player.PlayerCreatedEvent;

import javax.inject.Named;

@Named
public class PlayerCreatedEventHandler {

    private final PlayerProjectionRepository playerProjectionRepository;

    public PlayerCreatedEventHandler(PlayerProjectionRepository playerProjectionRepository) {
        this.playerProjectionRepository = playerProjectionRepository;
    }

    @EventHandler
    @SuppressWarnings("unused") // Axon
    public void on(PlayerCreatedEvent event) {
        PlayerProjection player = new PlayerProjection(event.getPlayerId(), event.getName(), event.getAlias(), event.getAverage());
        playerProjectionRepository.save(player);
    }
}
