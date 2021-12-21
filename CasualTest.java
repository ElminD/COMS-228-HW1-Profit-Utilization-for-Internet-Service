package edu.iastate.cs228.hw1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasualTest {
    Town t = new Town(4,4);
    Casual c = new Casual(t, 1, 2);

//just test if who returns the right state
    @Test
    void test() {
            assertEquals(c.who(), State.CASUAL);
    }
}
