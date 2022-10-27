package com.example.battlegame;

public class Player {
    private String name;

    private Classes fighterClass;

    private int[] attributes = {50,50,50,50};//Strength, Speed, Health, Defense

    private int playerlevel;

    private int xp;

    private int coins;

    private Inventory inventory = new Inventory();

    public Player(String name, Classes fighterclass){
        this.name = name;
        this.fighterClass = fighterclass;
        for (int i = 0; i < attributes.length; i++) {
            attributes[i] += fighterclass.getAttributeChanges()[i];
        }
        playerlevel = 1;
    }
    public Player(Classes fighterclass, Player player){
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

    protected void changeAttributes(int index, int change){
        attributes[index] += change;//Strength, Speed, Health, Defense
    }

    public int getCoins() {
        return coins;
    }

    public int getXp() {
        return xp;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void changeCoins(int coins) {
        this.coins += coins;
    }

    public void changePlayerlevel(int playerlevel) {
        this.playerlevel += playerlevel;
    }

    public void changeXp(int xp) {
        this.xp += xp;
    }
}
