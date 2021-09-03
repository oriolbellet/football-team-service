package org.oriolbellet.football.team.application.query.lineup;

import org.axonframework.eventhandling.EventHandler;
import org.oriolbellet.football.team.application.command.lineup.LineUpCreatedEvent;

import javax.inject.Named;
import java.util.Collections;

@Named
public class LineUpCreatedEventHandler {

    private final LineUpProjectionRepository lineUpProjectionRepository;

    public LineUpCreatedEventHandler(LineUpProjectionRepository lineUpProjectionRepository) {
        this.lineUpProjectionRepository = lineUpProjectionRepository;
    }

    @EventHandler
    @SuppressWarnings("unused") // Used by Axon
    public void on(LineUpCreatedEvent event) {
        LineUpProjection lineUpProjection = new LineUpProjection(event.getLineUpId(), Collections.emptyList(), TacticProjection.valueOf(event.getTactic()));
        lineUpProjectionRepository.save(lineUpProjection);
    }
}
