package org.cubas;

import org.junit.jupiter.api.Test;

import static org.cubas.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void deltaVShouldEqualNumber() {
        assertEquals(2079.44,calculateDeltaV(100.0,50.0,3000.0),0.01);

    }

    @Test
    void deltaVEdgeCase() {
        assertEquals(0.0,calculateDeltaV(1.0,1.0,1.0),0.01);
    }

    @Test
    void twoPlusThreeShouldEqualFive(){
        assertEquals(500.0, calculateInitialMass(200.0,300.0));
    }

    @Test
    void shouldNotGoToOrbit(){
        assertFalse(canGoToOrbit(8900.0,1.5));
    }

    @Test
    void shouldGoToOrbit(){
        assertTrue(canGoToOrbit(9600.1,1.5));
    }


}