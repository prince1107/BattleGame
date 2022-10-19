package com.example.battlegame;

public class Items {
    private String name;

    private int damage;
    private int healing;
    private int speed;
    private int addedHealth;
    private int defense;

    public Items(String name, int damage, int healing, int speed, int addedHealth, int defense){
        this.name = name;

        this.damage = damage;
        this.healing = healing;
        this.speed = speed;
        this.addedHealth = addedHealth;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getAddedHealth() {
        return addedHealth;
    }

    public int getHealing() {
        return healing;
    }

    public int getSpeed() {
        return speed;
    }
}
