package org.oriolbellet.football.team.adapter.in;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.oriolbellet.football.team.application.domain.TeamView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class GetTeamsController {

    private final QueryGateway queryGateway;

    public GetTeamsController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public CompletableFuture<List<TeamView>> getTeams() {
        return queryGateway.query("getAllTeams", null, ResponseTypes.multipleInstancesOf(TeamView.class));
    }
}

