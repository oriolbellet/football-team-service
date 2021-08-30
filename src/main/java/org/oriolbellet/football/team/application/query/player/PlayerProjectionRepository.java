package org.oriolbellet.football.team.application.query.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PlayerProjectionRepository extends JpaRepository<PlayerProjection, UUID> {

    @Query("SELECT p FROM TEAM t, PLAYER p JOIN t.squad s WHERE t.teamId = :teamId AND s = p.playerId")
    List<PlayerProjection> findAllPlayersByTeamId(UUID teamId);
}
