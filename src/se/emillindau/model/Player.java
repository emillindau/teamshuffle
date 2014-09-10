package se.emillindau.model;

/**
 * Created by Emil on 2014-05-05.
 * assigned to spelrepubliken in se.emillindau
 */
public class Player {

    private final int ID;

    private String mName;
    private int mPoints;

    public Player(String name) {
        mName = name;
        ID = 1;
    }

    public String getName() {
        return mName;
    }

    public void addPoints(int amount) {
        mPoints += amount;
    }

    public int getPoints() {
        return mPoints;
    }
}
