package org.oriolbellet.football.team.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeamView {

    @Id
    private UUID teamId;

}
