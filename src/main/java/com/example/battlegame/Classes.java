package com.example.battlegame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Classes {
    private String className;

    private int[] attributeChanges;//Strength, Speed, Health, Defense

    private ArrayList<Attack> attacks = new ArrayList<>();


    public Classes(String className){
        this.className = className;
        if(className.equals("knight")){
            this.attributeChanges = new int[]{20,-5,0,10};

            attacks.add(new Attack("Piercing Stab", 15));
            attacks.add(new Attack("Slice", 5));
            attacks.add(new Attack("Sharpness++", 0));
            attacks.add(new Attack("Lance Dash", 20));
            attacks.add(new Attack("Sweep & Slice", 10));

        } else if(className.equals("mage")){
            this.attributeChanges = new int[]{-10,15,20,0};

            attacks.add(new Attack("Fire Rain", 30));
            attacks.add(new Attack("Shadow Slice", 25));
            attacks.add(new Attack("Speed++", 0));
            attacks.add(new Attack("Sun Spear", 35));
            attacks.add(new Attack("Water Whip", 10));

        } else if(className.equals("archer")){
            this.attributeChanges = new int[]{-10,25,0,10};

            attacks.add(new Attack("Piercing Arrows", 10));
            attacks.add(new Attack("Exploding Arrows", 25));
            attacks.add(new Attack("Speed++", 0));
            attacks.add(new Attack("Loudest Arrows", 10));
            attacks.add(new Attack("Multishot", 20));

        } else if(className.equals("bard")){
            this.attributeChanges = new int[]{20,-5,0,10};

            attacks.add(new Attack("Bagpipe Shriek", 5));
            attacks.add(new Attack("Flute Slice", 10));
            attacks.add(new Attack("Health Song", 0));
            attacks.add(new Attack("Xylophone Confusion", 5));
            attacks.add(new Attack("Speed Song", 15));

        } else if(className.equals("shooter")){
            this.attributeChanges = new int[]{20,-5,0,10};
            attacks.add(new Attack("Piercing Bullets", 20));
            attacks.add(new Attack("Bayonet Slice", 10));
            attacks.add(new Attack("Speed++", 0));
            attacks.add(new Attack("Snipe", 100000));
            attacks.add(new Attack("MultiShot", 30));

        }
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public int[] getAttributeChanges() {
        return attributeChanges;
    }

    public String getClassName() {
        return className;
    }
}
