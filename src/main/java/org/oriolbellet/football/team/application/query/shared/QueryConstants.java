package org.oriolbellet.football.team.application.query.shared;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QueryConstants {

    public static final String QUERY_GET_DEFAULT_TEAMS = "getDefaultTeams";
    public static final String QUERY_GET_LINEUP_BY_TEAM_ID = "getLineUpByTeamId";
    public static final String QUERY_GET_LINEUP_BY_ID = "getLineUpById";
    public static final String QUERY_GET_PAYERS_BY_LINEUP_ID = "getPlayersByLineUpId";
    public static final String QUERY_GET_PAYERS_BY_TEAM_ID = "getPlayersByTeamId";


}
