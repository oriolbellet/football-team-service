package org.oriolbellet.football.team.application.query.team;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

interface TeamProjectionRepository extends JpaRepository<TeamProjection, UUID> {
    List<TeamProjection> findByDefTrue();
}
