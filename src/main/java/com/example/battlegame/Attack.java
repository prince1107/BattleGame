package com.example.battlegame;

import java.util.ArrayList;

public class Attack {
    private String attackName;

    private double attackDamage;

    private int cooldown = 0;

    private int lastused = 0;

    public Attack(String attackName, int attackDamage){
        this.attackName = attackName;
        this.attackDamage = attackDamage;
    }

    public Attack(String attackName, int attackDamage, int cooldown){
        this.attackName = attackName;
        this.attackDamage = attackDamage;
        this.cooldown = cooldown;
    }

    public String getAttackName() {
        return attackName;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getLastused() {
        return lastused;
    }

    public void setLastused(int lastused) {
        this.lastused = lastused;
    }
}
