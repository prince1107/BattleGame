package com.example.battlegame;

public class Items {
    private String name;

    private int damage;
    private int healing;
    private int speed;
    private int defense;

    private int shopPrice;

    public Items(String name, int damage, int healing, int speed, int defense, int shopPrice){
        this.name = name;

        this.damage = damage;
        this.healing = healing;
        this.speed = speed;
        this.defense = defense;
        this.shopPrice = shopPrice;
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

    public int getHealing() {
        return healing;
    }

    public int getSpeed() {
        return speed;
    }

    public int getShopPrice() {
        return shopPrice;
    }
}
