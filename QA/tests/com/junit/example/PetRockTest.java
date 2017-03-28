package com.junit.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jagadeesh on 26/03/17.
 */
public class PetRockTest {
    @Test
    public void getName() throws Exception {
        PetRock rock = new PetRock("Rocko");
        assertEquals("Rocko", rock.getName());

    }

    @Test
    public void isHealthy() throws Exception {
        PetRock rock = new PetRock("Rocko");
        assertFalse(rock.isHealthy());
    }

}