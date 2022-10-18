package com.example.battlegame;

public class Player {
    private String name;

    private Classes fighterClass;

    private int[] attributes = {50,50,50,50};

    private int playerlevel;

    public Player(String name, Classes fighterclass){
        this.name = name;
        this.fighterClass = fighterclass;
        for (int i = 0; i < attributes.length; i++) {
            attributes[i] += fighterclass.getAttributeChanges()[i];
        }
        playerlevel = 1;
    }
    public Player(Classes fighterclass, Player player){
        this.name = name;
        this.fighterClass = fighterclass;
        for (int i = 0; i < attributes.length; i++) {
            attributes[i] += fighterclass.getAttributeChanges()[i]*player.getPlayerlevel();
        }
    }

    public String getName() {
        return name;
    }

    public Classes getFighterClass() {
        return fighterClass;
    }

    public int[] getAttributes() {
        return attributes;
    }

    public int getPlayerlevel() {
        return playerlevel;
    }
}
