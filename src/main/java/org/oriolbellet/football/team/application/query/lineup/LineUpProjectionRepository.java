package org.oriolbellet.football.team.application.query.lineup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LineUpProjectionRepository extends JpaRepository<LineUpProjection, UUID> {
}
