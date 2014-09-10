package se.emillindau.test;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.emillindau.model.Player;

/**
 * Created by Emil on 2014-05-05.
 * assigned to spelrepubliken in se.emillindau
 */
public class PlayerTest extends TestCase {

    private Player mPlayer;
    private static final String NAME = "TestName";

    @Before
    public void setUp() throws Exception {
        mPlayer = new Player(NAME);
        assertNotNull(mPlayer);
    }

    @After
    public void tearDown() throws Exception {
        mPlayer = null;
    }

    @Test
    public void testGetName() throws Exception {
        String expected = NAME;
        assertEquals("Expected name", expected, mPlayer.getName());
    }

    @Test
    public void testPoints() {
        int expected = 1;
        mPlayer.addPoints(1);
        assertEquals("Expected points", expected, mPlayer.getPoints());
    }

}
