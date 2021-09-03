package org.oriolbellet.football.team.adapter.in;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.oriolbellet.football.team.application.query.player.PlayerProjection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams/api/v1")
public class GetTeamPlayersController {

    private final QueryGateway queryGateway;

    public GetTeamPlayersController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{teamId}/players")
    public CompletableFuture<List<PlayerDto>> getTeams(@PathVariable("teamId") UUID teamId) {
        return queryGateway.query("getPlayersByTeam", teamId, ResponseTypes.multipleInstancesOf(PlayerProjection.class))
                .thenApply(players -> players.stream()
                        .map(player -> new PlayerDto(player.getPlayerId(), player.getName(), player.getAverage()))
                        .collect(Collectors.toList()));
    }
}
