package com.example.battlegame;

import java.util.ArrayList;

public class Attack {
    private String attackName;

    private int attackDamage;

    public Attack(String attackName, int attackDamage){
        this.attackName = attackName;
        this.attackDamage = attackDamage;
    }

    public String getAttackName() {
        return attackName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}
