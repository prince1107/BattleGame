package com.example.battlegame;

public class Player {
    private String name;

    private Classes fighterClass;

    private double[] attributes = {50,50,100,50};//Strength, Speed, Health, Defense

    private int playerlevel = 1;

    private int xp = 0;

    private int coins = 1000;

    private Inventory inventory = new Inventory();

    public Player(String name, Classes fighterclass){
        this.name = name;
        this.fighterClass = fighterclass;
        for (int i = 0; i < attributes.length; i++) {
            attributes[i] += fighterclass.getAttributeChanges()[i];
        }
    }
    public Player(Classes fighterclass, Player player){
        this.name = "Computer";
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

    public double[] getAttributes() {
        return attributes;
    }

    public int getPlayerlevel() {
        return playerlevel;
    }

    protected void changeAttributes(int index, double change){
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
