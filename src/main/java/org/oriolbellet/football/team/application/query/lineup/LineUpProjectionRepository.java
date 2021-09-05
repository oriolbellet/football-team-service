package org.oriolbellet.football.team.application.query.lineup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface LineUpProjectionRepository extends JpaRepository<LineUpProjection, UUID> {
    @Query("SELECT l FROM TEAM t, LINEUP l WHERE t.teamId = :teamId AND t.lineUpId = l.lineUpId")
    Optional<LineUpProjection> findByTeamId(UUID teamId);
}
