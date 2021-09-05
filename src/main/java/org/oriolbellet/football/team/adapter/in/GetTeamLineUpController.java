package org.oriolbellet.football.team.adapter.in;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.oriolbellet.football.team.adapter.in.dto.LineUpDto;
import org.oriolbellet.football.team.adapter.in.dto.PlayerDto;
import org.oriolbellet.football.team.application.query.lineup.LineUpProjection;
import org.oriolbellet.football.team.application.query.player.PlayerProjection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.oriolbellet.football.team.application.query.shared.QueryConstants.QUERY_GET_LINEUP_BY_TEAM_ID;
import static org.oriolbellet.football.team.application.query.shared.QueryConstants.QUERY_GET_PAYERS_BY_LINEUP_ID;

@RestController
@RequestMapping("/teams/api/v1")
public class GetTeamLineUpController {

    private final QueryGateway queryGateway;

    public GetTeamLineUpController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{teamId}/lineup")
    public CompletableFuture<CompletableFuture<LineUpDto>> getTeamLineUp(@PathVariable("teamId") UUID teamId) {
        return queryGateway.query(QUERY_GET_LINEUP_BY_TEAM_ID, teamId, ResponseTypes.instanceOf(LineUpProjection.class))
                .thenApply(lineUpProjection ->
                        queryGateway.query(QUERY_GET_PAYERS_BY_LINEUP_ID, lineUpProjection.getLineUpId(), ResponseTypes.multipleInstancesOf(PlayerProjection.class))
                                .thenApply(playersProjection -> playersProjection.stream()
                                        .map(playerProjection -> new PlayerDto(
                                                playerProjection.getPlayerId(),
                                                playerProjection.getAlias(),
                                                playerProjection.getAverage()))
                                        .collect(Collectors.toList()))
                                .thenApply(players -> new LineUpDto(
                                        lineUpProjection.getLineUpId(),
                                        lineUpProjection.getTactic().toString(),
                                        players)));
    }
}
