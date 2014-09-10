package se.emillindau.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Emil on 2014-05-05.
 * assigned to spelrepubliken in se.emillindau
 */
public class MatchMaker {

    private static final int MAX_PLAYERS = 10;
    private final int CURRENT_MAX_PLAYERS;

    private int mCurrentIndex = 0;

    private Player[] mPlayers;

    private Team mTeamA;
    private Team mTeamB;
    private boolean mIsDivided;

    public MatchMaker() throws Exception {
        this(MAX_PLAYERS);
    }

    public MatchMaker(int maxPlayers) throws Exception {
        if(maxPlayers % 2 != 0) {
            throw new Exception("Måste vara jämnt antal spelare");
        }

        CURRENT_MAX_PLAYERS = maxPlayers;
        mPlayers = new Player[maxPlayers];
        mTeamA = new Team();
        mTeamB = new Team();
        mIsDivided = false;
    }

    /**
     * Add a player to the player pool
     * @param player
     * @throws Exception if full
     */
    public void addPlayer(Player player) throws Exception {
        if(mCurrentIndex >= CURRENT_MAX_PLAYERS) {
            throw new Exception("Fullt med spelare");
        } else {
            mPlayers[mCurrentIndex] = player;
            mCurrentIndex++;

            if(mCurrentIndex == CURRENT_MAX_PLAYERS) {
                // The team is done and we should divide
                divideTeams();
            }
        }
    }

    /**
     * Divide the teams equally
     */
    private void divideTeams() {
        List<Player> players = new ArrayList<Player>();
        List<Player> sortedPlayers;

        for (Player player : mPlayers) {
            players.add(player);
        }

        sortedPlayers = Utils.quickSortByScore(players);

        for (int i = 0; i < sortedPlayers.size(); i++) {
            if(mTeamA.sum() <= mTeamB.sum()) {
                if(!mTeamA.addPlayer(sortedPlayers.get(i))) {
                    mTeamB.addPlayer(sortedPlayers.get(i));
                }
            } else {
                if(!mTeamB.addPlayer(sortedPlayers.get(i))) {
                    mTeamA.addPlayer(sortedPlayers.get(i));
                }
            }
        }

        printTeams();
    }

    /**
     * Finally creates the match
     * @return
     * @throws Exception
     */
    public Match createMatch() throws Exception {
        if(!mIsDivided) {
            throw new Exception("Teams hasn't been divided");
        }

        return new Match(mTeamA, mTeamB);
    }

    private void printTeams() {
        System.out.println("\n-- TEAM A --");
        System.out.println("Total score: " + mTeamA.sum());
        for (Player p : mTeamA.getPlayers()) {
            System.out.println("Player: " + p.getName() + ", " + p.getPoints());
        }

        System.out.println("\n-- TEAM B --");
        System.out.println("Total score: " + mTeamB.sum());
        for (Player p : mTeamB.getPlayers()) {
            System.out.println("Player: " + p.getName() + ", " + p.getPoints());
        }
    }

    /***
     * TEST METHODS
     */

    public void generateTestPlayers() {
        String name = "PlayerNr";

        for(int i = 0; i < 10; i++) {
            try {
                Player p = new Player(name + String.valueOf(i));
                if(i < 5) {
                    p.addPoints(0);
                } else {
                    p.addPoints(1000);
                }
                p.addPoints(generateTestScore());
                addPlayer(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i < mPlayers.length; i++) {
            System.out.println("Player: " + mPlayers[i].getName() + ", Score: " + mPlayers[i].getPoints());
        }

        try {
            divideTeams();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int generateTestScore() {
        try {
            Thread.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random r = new Random();
        int low = 10;
        int high = 100;
        int rand = r.nextInt(high-low) + low;
        return rand;
    }
}
