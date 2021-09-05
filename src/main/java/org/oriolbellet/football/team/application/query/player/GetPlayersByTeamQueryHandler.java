package org.oriolbellet.football.team.application.query.player;

import org.axonframework.queryhandling.QueryHandler;

import javax.inject.Named;
import java.util.List;
import java.util.UUID;

import static org.oriolbellet.football.team.application.query.shared.QueryConstants.QUERY_GET_PAYERS_BY_TEAM_ID;

@Named
public class GetPlayersByTeamQueryHandler {

    private final PlayerProjectionRepository repository;

    public GetPlayersByTeamQueryHandler(PlayerProjectionRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("unused") // Axon
    @QueryHandler(queryName = QUERY_GET_PAYERS_BY_TEAM_ID)
    public List<PlayerProjection> getPlayersByTeamId(UUID teamId) {
        //TODO: Use custom exceptions
        return repository.findAllPlayersByTeamId(teamId);
    }
}
