package com.example.battlegame;

public class Items {
    private String name;

    private double damage;
    private double healing;
    private double speed;
    private double defense;

    private int shopPrice;

    public Items(String name, double damage, double healing, double speed, double defense, int shopPrice){
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

    public double getDamage() {
        return damage;
    }

    public double getDefense() {
        return defense;
    }

    public double getHealing() {
        return healing;
    }

    public double getSpeed() {
        return speed;
    }

    public int getShopPrice() {
        return shopPrice;
    }
}
