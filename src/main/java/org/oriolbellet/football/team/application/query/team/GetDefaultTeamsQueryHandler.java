package org.oriolbellet.football.team.application.query.team;

import org.axonframework.queryhandling.QueryHandler;

import javax.inject.Named;
import java.util.List;

@Named
public class GetDefaultTeamsQueryHandler {

    private final TeamProjectionRepository teamProjectionRepository;

    public GetDefaultTeamsQueryHandler(TeamProjectionRepository teamProjectionRepository) {
        this.teamProjectionRepository = teamProjectionRepository;
    }

    @SuppressWarnings("unused") // Used by Axon
    @QueryHandler(queryName = "getDefaultTeams")
    public List<TeamProjection> getDefaultTeams() {
        return teamProjectionRepository.findByDefTrue();
    }
}
