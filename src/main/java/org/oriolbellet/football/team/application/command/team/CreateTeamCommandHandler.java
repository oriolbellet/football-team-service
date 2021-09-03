package org.oriolbellet.football.team.application.command.team;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.Aggregate;
import org.axonframework.modelling.command.Repository;
import org.oriolbellet.football.team.application.command.lineup.AddPlayerToLineUpCommand;
import org.oriolbellet.football.team.application.command.lineup.LineUp;
import org.oriolbellet.football.team.application.command.player.Player;
import org.oriolbellet.football.team.application.query.lineup.GetLineUpQueryHandler;
import org.oriolbellet.football.team.application.query.player.GetPlayersByTeamQueryHandler;
import org.oriolbellet.football.team.application.query.player.PlayerProjection;
import org.oriolbellet.football.team.application.query.team.GetTeamQueryHandler;
import org.oriolbellet.football.team.application.query.lineup.LineUpProjection;
import org.oriolbellet.football.team.application.query.team.TeamProjection;

import javax.inject.Named;
import java.util.List;
import java.util.UUID;

@Named
public class CreateTeamCommandHandler {

    private final Repository<Team> teamRepository;
    private final Repository<LineUp> lineUpRepository;
    private final Repository<Player> playerRepository;
    private final GetTeamQueryHandler getTeamQueryHandler;
    private final GetLineUpQueryHandler getLineUpQueryHandler;
    private final GetPlayersByTeamQueryHandler getPlayersByTeamQueryHandler;

    @SuppressWarnings("all") // Axon bean
    public CreateTeamCommandHandler(Repository<Team> teamRepository, Repository<LineUp> lineUpRepository, Repository<Player> playerRepository, GetTeamQueryHandler getTeamQueryHandler, GetLineUpQueryHandler getLineUpQueryHandler, GetPlayersByTeamQueryHandler getPlayersByTeamQueryHandler) {
        this.teamRepository = teamRepository;
        this.lineUpRepository = lineUpRepository;
        this.playerRepository = playerRepository;
        this.getTeamQueryHandler = getTeamQueryHandler;
        this.getLineUpQueryHandler = getLineUpQueryHandler;
        this.getPlayersByTeamQueryHandler = getPlayersByTeamQueryHandler;
    }

    @CommandHandler
    @SuppressWarnings("unused") // Axon
    public void createTeam(CreateTeamCommand cmd) {

        TeamProjection teamProjection = getTeamQueryHandler.getTeam(cmd.getSourceTeamId());
        LineUpProjection lineUpProjection = getLineUpQueryHandler.getLineUp(teamProjection.getLineUpId());
        List<PlayerProjection> playerProjections = getPlayersByTeamQueryHandler.getPlayersByTeam(teamProjection.getTeamId());

        UUID lineUpId = UUID.randomUUID();

        Aggregate<LineUp> lineUpAggregate = createLineUp(lineUpId, lineUpProjection);
        Aggregate<Team> teamAggregate = createTeam(cmd.getTeamId(), teamProjection, lineUpId);

        playerProjections.forEach(playerProjection -> {
            UUID playerId = UUID.randomUUID();
            createPlayer(playerId, playerProjection);
            addPlayerToTeam(teamAggregate, playerId);
            addPlayerToLineUp(lineUpAggregate, playerId);
        });
    }

    private Aggregate<Team> createTeam(UUID teamId, TeamProjection teamProjection, UUID lineUpId) {
        try {
            return teamRepository.newInstance(() -> new Team(teamId, teamProjection.getName(), lineUpId));
        } catch (Exception e) {
            //TODO: Specific exception
            throw new RuntimeException("");
        }
    }

    private Aggregate<LineUp> createLineUp(UUID lineUpId, LineUpProjection lineUpProjection) {
        try {
            return lineUpRepository.newInstance(() -> new LineUp(lineUpId, lineUpProjection.getTactic().toString()));
        } catch (Exception e) {
            //TODO: Specific exception
            throw new RuntimeException("");
        }
    }

    private void createPlayer(UUID playerId, PlayerProjection player) {
        try {
            playerRepository.newInstance(() -> new Player(playerId, player.getName(), player.getAlias(), player.getAverage()));
        } catch (Exception e) {
            //TODO: Specific exception
            throw new RuntimeException("");
        }
    }

    private void addPlayerToTeam(Aggregate<Team> teamAggregate, UUID playerId) {
        teamAggregate.execute(team -> team.handle(new AddPlayerToTeamCommand(team.getTeamId(), playerId)));
    }

    private void addPlayerToLineUp(Aggregate<LineUp> lineUpAggregate, UUID playerId) {
        lineUpAggregate.execute(lineUp -> lineUp.handle(new AddPlayerToLineUpCommand(lineUp.getLineUpId(), playerId)));
    }
}
