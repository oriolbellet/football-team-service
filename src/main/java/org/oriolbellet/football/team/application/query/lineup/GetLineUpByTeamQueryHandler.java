package org.oriolbellet.football.team.application.query.lineup;

import org.axonframework.queryhandling.QueryHandler;

import javax.inject.Named;
import java.util.UUID;

import static org.oriolbellet.football.team.application.query.shared.QueryConstants.QUERY_GET_LINEUP_BY_TEAM_ID;

@Named
public class GetLineUpByTeamQueryHandler {

    private final LineUpProjectionRepository lineUpProjectionRepository;

    public GetLineUpByTeamQueryHandler(LineUpProjectionRepository lineUpProjectionRepository) {
        this.lineUpProjectionRepository = lineUpProjectionRepository;
    }

    @SuppressWarnings("unused") // Axon
    @QueryHandler(queryName = QUERY_GET_LINEUP_BY_TEAM_ID)
    public LineUpProjection getLineUpByTeam(UUID teamId) {
        //TODO: Use custom exceptions
        return lineUpProjectionRepository.findByTeamId(teamId).orElseThrow(RuntimeException::new);
    }
}
