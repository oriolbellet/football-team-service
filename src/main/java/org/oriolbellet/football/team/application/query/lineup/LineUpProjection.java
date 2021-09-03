package org.oriolbellet.football.team.application.query.lineup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity(name = "LINEUP")
@Table(name = "LINEUP")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LineUpProjection {

    @Id
    @Column(name = "LINEUP_ID")
    private UUID lineUpId;

    @ElementCollection
    private List<UUID> players;

    @Column(name = "TACTIC")
    @Enumerated(EnumType.STRING)
    private TacticProjection tactic;

    public void addPlayer(UUID player) {
        players.add(player);
    }
}
