package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TownTest {

   
        Town t = new Town(4,4);

//checks the length
    @Test
    void test() {
    assertEquals(t.getLength(),4);
    }
}
