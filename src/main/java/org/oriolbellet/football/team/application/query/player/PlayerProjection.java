package org.oriolbellet.football.team.application.query.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "PLAYER")
@Table(name = "PLAYER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerProjection {

    @Id
    @Column(name = "PLAYER_ID")
    private UUID playerId;

    @Column
    private String name;

    @Column
    private String alias;

    @Column
    private int average;

}
