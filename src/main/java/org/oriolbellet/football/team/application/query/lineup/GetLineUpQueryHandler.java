package org.oriolbellet.football.team.application.query.lineup;

import org.axonframework.queryhandling.QueryHandler;

import javax.inject.Named;
import java.util.UUID;

@Named
public class GetLineUpQueryHandler {

    private final LineUpProjectionRepository lineUpProjectionRepository;

    public GetLineUpQueryHandler(LineUpProjectionRepository lineUpProjectionRepository) {
        this.lineUpProjectionRepository = lineUpProjectionRepository;
    }

    @SuppressWarnings("unused") // Axon
    @QueryHandler(queryName = "getLineUp")
    public LineUpProjection getLineUp(UUID lineUpId) {
        //TODO: Use custom exceptions
        return lineUpProjectionRepository.findById(lineUpId).orElseThrow(RuntimeException::new);
    }
}
