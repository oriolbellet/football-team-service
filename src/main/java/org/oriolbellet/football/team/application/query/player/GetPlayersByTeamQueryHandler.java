package org.oriolbellet.football.team.application.query.player;

import org.axonframework.queryhandling.QueryHandler;

import javax.inject.Named;
import java.util.List;
import java.util.UUID;

@Named
public class GetPlayersByTeamQueryHandler {

    private final PlayerProjectionRepository repository;

    public GetPlayersByTeamQueryHandler(PlayerProjectionRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("unused") // Axon
    @QueryHandler(queryName = "getPlayersByTeam")
    public List<PlayerProjection> getPlayersByTeam(UUID teamId) {
        //TODO: Use custom exceptions
        return repository.findAllPlayersByTeamId(teamId);
    }
}
