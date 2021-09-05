package org.oriolbellet.football.team.adapter.in;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.oriolbellet.football.team.adapter.in.dto.TeamDto;
import org.oriolbellet.football.team.adapter.in.dto.PlayerDto;
import org.oriolbellet.football.team.application.query.player.PlayerProjection;
import org.oriolbellet.football.team.application.query.team.TeamProjection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.oriolbellet.football.team.application.query.shared.QueryConstants.QUERY_GET_PAYERS_BY_TEAM_ID;

@RestController
@RequestMapping("/teams/api/v1")
public class GetTeamController {

    private final QueryGateway queryGateway;

    public GetTeamController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{teamId}")
    public CompletableFuture<CompletableFuture<TeamDto>> getTeam(@PathVariable("teamId") UUID teamId) {
        return queryGateway.query("getTeam", teamId, ResponseTypes.instanceOf(TeamProjection.class))
                .thenApply(team ->
                        queryGateway.query(QUERY_GET_PAYERS_BY_TEAM_ID, team.getTeamId(), ResponseTypes.multipleInstancesOf(PlayerProjection.class))
                                .thenApply(players -> players.stream().map(player -> new PlayerDto(player.getPlayerId(), player.getAlias(), player.getAverage())))
                                .thenApply(playerProjections -> new TeamDto(teamId, team.getName(), playerProjections.collect(Collectors.toList())))
                );
    }
}
