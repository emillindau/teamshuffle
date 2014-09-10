package se.emillindau.model;

import se.emillindau.model.Player;

/**
 * Created by Emil on 2014-05-05.
 * assigned to spelrepubliken in se.emillindau
 */
public class Team {

    private static final int MAX_PLAYERS = 5;

    private int mCurrentIdx = 0;
    private Player[] mPlayers;
    private boolean mIsFull;

    public Team() {
        mPlayers = new Player[MAX_PLAYERS];
        mIsFull = false;
    }

    public boolean addPlayer(Player player) {
        if(mCurrentIdx >= MAX_PLAYERS) {
            return false;
        }

        mPlayers[mCurrentIdx] = player;
        mCurrentIdx++;

        if(mCurrentIdx == MAX_PLAYERS) {
            mIsFull = true;
        }

        return true;
    }

    public boolean isFull() {
        return mIsFull;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < mPlayers.length; i++) {
            if(mPlayers[i] != null) {
                sum += mPlayers[i].getPoints();
            }
        }
        return sum;
    }

    public Player[] getPlayers() {
        return mPlayers;
    }

}
