package org.oriolbellet.football.team.application.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamProjectorRepository extends JpaRepository<TeamView, UUID> {
}
