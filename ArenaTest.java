package Swiggy_Project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    @Test
    public void testPlayerInitialization() {
        Player player = new Player(100, 10, 15);
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(15, player.getAttack());
    }

    @Test
    public void testDiceRoll() {
        Dice dice = new Dice();
        for (int i = 0; i < 100; i++) {
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void testPlayerDefend() {
        Player player = new Player(100, 10, 15);
        player.defend(30);
        assertEquals(70, player.getHealth());

        player.defend(80);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testFight() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        Arena arena = new Arena(playerA, playerB);
        arena.startFight();

        assertTrue(!playerA.isAlive() || !playerB.isAlive());
    }
}

