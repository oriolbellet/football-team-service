package org.oriolbellet.football.team.application.query.lineup;

import org.axonframework.queryhandling.QueryHandler;

import javax.inject.Named;
import java.util.UUID;

import static org.oriolbellet.football.team.application.query.shared.QueryConstants.QUERY_GET_LINEUP_BY_ID;

@Named
public class GetLineUpQueryHandler {

    private final LineUpProjectionRepository lineUpProjectionRepository;

    public GetLineUpQueryHandler(LineUpProjectionRepository lineUpProjectionRepository) {
        this.lineUpProjectionRepository = lineUpProjectionRepository;
    }

    @SuppressWarnings("unused") // Axon
    @QueryHandler(queryName = QUERY_GET_LINEUP_BY_ID)
    public LineUpProjection getLineUpById(UUID lineUpId) {
        //TODO: Use custom exceptions
        return lineUpProjectionRepository.findById(lineUpId).orElseThrow(RuntimeException::new);
    }
}
