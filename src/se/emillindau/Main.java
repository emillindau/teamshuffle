package se.emillindau;

import se.emillindau.model.MatchMaker;

public class Main {

    public static void main(String[] args) {
        MatchMaker td = null;
        try {
            td = new MatchMaker();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert td != null;
        td.generateTestPlayers();
    }
}
