package org.oriolbellet.football.team.application.query.lineup;

import org.axonframework.eventhandling.EventHandler;
import org.oriolbellet.football.team.application.command.lineup.PlayerAddedToLineUpEvent;

import javax.inject.Named;

@Named
public class PlayerAddedToLineUpEventHandler {

    private final LineUpProjectionRepository lineUpProjectionRepository;

    public PlayerAddedToLineUpEventHandler(LineUpProjectionRepository lineUpProjectionRepository) {
        this.lineUpProjectionRepository = lineUpProjectionRepository;
    }

    @EventHandler
    @SuppressWarnings("unused") // Used by Axon
    public void on(PlayerAddedToLineUpEvent event) {
        LineUpProjection lineUp = lineUpProjectionRepository.findById(event.getLineUpId()).orElseThrow(RuntimeException::new);
        lineUp.addPlayer(event.getPlayerId());
        lineUpProjectionRepository.save(lineUp);
    }
}
