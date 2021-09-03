package org.oriolbellet.football.team.application.query.team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity(name = "TEAM")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TEAM")
public class TeamProjection {

    @Id
    @Column(name = "TEAM_ID")
    private UUID teamId;

    private String name;

    @ElementCollection
    @JoinColumn(name = "TEAM_ID")
    private List<UUID> squad;

    private UUID lineUpId;
    private boolean def;

    public void addPlayer(UUID playerId) {
        squad.add(playerId);
    }
}
