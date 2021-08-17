package org.oriolbellet.football.team.application.query;

import org.axonframework.queryhandling.QueryHandler;
import org.oriolbellet.football.team.application.domain.TeamProjectorRepository;
import org.oriolbellet.football.team.application.domain.TeamView;

import javax.inject.Named;
import java.util.List;

@Named
public class GetAllTeamsQueryHandler {

    private final TeamProjectorRepository teamProjectorRepository;

    public GetAllTeamsQueryHandler(TeamProjectorRepository teamProjectorRepository) {
        this.teamProjectorRepository = teamProjectorRepository;
    }

    @SuppressWarnings("unused") // Used by Axon
    @QueryHandler(queryName = "getAllTeams")
    public List<TeamView> getAllTeams() {
        return teamProjectorRepository.findAll();
    }
}
