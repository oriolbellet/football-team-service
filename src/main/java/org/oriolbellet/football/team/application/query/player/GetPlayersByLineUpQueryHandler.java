package org.oriolbellet.football.team.application.query.player;

import org.axonframework.queryhandling.QueryHandler;

import javax.inject.Named;
import java.util.List;
import java.util.UUID;

import static org.oriolbellet.football.team.application.query.shared.QueryConstants.QUERY_GET_PAYERS_BY_LINEUP_ID;

@Named
public class GetPlayersByLineUpQueryHandler {

    private final PlayerProjectionRepository repository;

    public GetPlayersByLineUpQueryHandler(PlayerProjectionRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("unused") // Axon
    @QueryHandler(queryName = QUERY_GET_PAYERS_BY_LINEUP_ID)
    public List<PlayerProjection> getPlayersByLineUpId(UUID lineUpId) {
        //TODO: Use custom exceptions
        return repository.findAllPlayersByLineUpId(lineUpId);
    }
}
