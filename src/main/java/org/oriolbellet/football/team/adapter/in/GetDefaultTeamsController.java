package org.oriolbellet.football.team.adapter.in;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.oriolbellet.football.team.application.query.team.TeamProjection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams/api/v1")
public class GetDefaultTeamsController {

    private final QueryGateway queryGateway;

    public GetDefaultTeamsController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public CompletableFuture<List<TeamDto>> getTeams() {
        return queryGateway.query("getDefaultTeams", null, ResponseTypes.multipleInstancesOf(TeamProjection.class))
                .thenApply(teams -> teams.stream()
                        .map(team -> new TeamDto(team.getTeamId(), team.getName()))
                        .collect(Collectors.toList()));
    }
}
