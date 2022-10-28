package com.example.battlegame;

import java.util.ArrayList;

public class Attack {
    private String attackName;

    private double attackDamage;

    public Attack(String attackName, int attackDamage){
        this.attackName = attackName;
        this.attackDamage = attackDamage;
    }

    public String getAttackName() {
        return attackName;
    }

    public double getAttackDamage() {
        return attackDamage;
    }
}
