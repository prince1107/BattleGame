package com.example.battlegame;

public class Player {
    private String name;

    private Classes fighterClass;

    private int[] attributes = {50,50,50,50};

    public Player(String name, Classes fighterclass){
        this.name = name;
        this.fighterClass = fighterclass;
        for (int i = 0; i < attributes.length; i++) {
            attributes[i] += fighterclass.getAttributeChanges()[i];
        }
    }

}
