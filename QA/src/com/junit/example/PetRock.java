package com.junit.example;

/*
  Youtube link: https://www.youtube.com/watch?v=Bld3644bIAo
 */
public class PetRock {

    private String name;
    private boolean healthy = false;

    public PetRock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHealthy() {
        return healthy;
    }
}
