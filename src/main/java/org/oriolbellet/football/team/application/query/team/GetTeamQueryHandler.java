package org.oriolbellet.football.team.application.query.team;

import org.axonframework.queryhandling.QueryHandler;

import javax.inject.Named;
import java.util.UUID;

@Named
public class GetTeamQueryHandler {

    private final TeamProjectionRepository teamProjectionRepository;

    public GetTeamQueryHandler(TeamProjectionRepository teamProjectionRepository) {
        this.teamProjectionRepository = teamProjectionRepository;
    }

    @SuppressWarnings("unused") // Used by Axon
    @QueryHandler(queryName = "getTeam")
    public TeamProjection getTeam(UUID teamId) {
        //TODO: Use custom exceptions
        return teamProjectionRepository.findById(teamId).orElseThrow(RuntimeException::new);
    }
}
