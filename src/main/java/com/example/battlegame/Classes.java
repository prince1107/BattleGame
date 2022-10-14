package com.example.battlegame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Classes {
    private String className;

    private String[] attacks = new String[5];

    private int[] attackDamage = new int[5];

    private int[] attributeChanges;//Strength, Speed, Health, Defense


    public Classes(String className){
        this.className = className;
        if(className.equals("knight")){
            this.attributeChanges = new int[]{20,-5,0,10};

        } else if(className.equals("mage")){
            this.attributeChanges = new int[]{-10,15,20,0};

        } else if(className.equals("archer")){
            this.attributeChanges = new int[]{-10,25,0,10};

        } else if(className.equals("bard")){
            this.attributeChanges = new int[]{20,-5,0,10};

        } else if(className.equals("shooter")){
            this.attributeChanges = new int[]{20,-5,0,10};

        }
    }
}
