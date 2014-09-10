package se.emillindau.model;

/**
 * Created by Emil on 2014-05-05.
 * assigned to spelrepubliken in se.emillindau
 */
public class Match {

    private static final int MAX_TEAMS = 2;

    private static final int WIN_SCORE = 25;
    private static final int DRAW_SCORE = 10;

    private Team[] mTeams;

    public Match(Team teamA, Team teamB) {
        mTeams = new Team[MAX_TEAMS];
        mTeams[0] = teamA;
        mTeams[1] = teamB;
    }

    public Team getTeamA() {
        return mTeams[0];
    }

    public Team getTeamB() {
        return mTeams[1];
    }

    public void setWinner(Team t) {
        for(Player p : t.getPlayers()) {
            p.addPoints(WIN_SCORE);
        }
    }

    public void setDraw() {
        for(Team t : mTeams) {
            for(Player p : t.getPlayers()) {
                p.addPoints(DRAW_SCORE);
            }
        }
    }
}
