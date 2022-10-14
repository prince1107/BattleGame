package com.example.battlegame;

import java.util.ArrayList;

public class Attacks {
    //change to get from text file

    private String[] knightattacks = new String[]{"Piercing Stab", "Slice", "Sharpness++", "Lance Dash", "Sweep & Slice"};
    private int[] knightdamage = new int[]{15, 5, 0, 20, 10};

    private String[] mageattacks = new String[]{"Fire Rain", "Shadow Slice", "Speed++", "Sun Spear", "Water Whip"};
    private int[] magedamage = new int[]{30, 25, 0, 35, 10};

    private String[] archerattacks = new String[]{"Piercing Arrows", "Exploding Arrows", "Speed++", "Loudest Arrows", "Multishot"};
    private int[] archerdamage = new int[]{10, 25, 0, 10, 20};

    private String[] bardattacks = new String[]{"Bagpipe Shriek", "Flute Slice", "Health Song", "Xylophone Confusion", "Speed Song"};
    private int[] barddamage = new int[]{5, 10, 0, 5, 15};

    private String[] shooterattacks = new String[]{"Piercing Bullets", "Bayonet Slice", "Speed++", "Snipe", "MultiShot"};
    private int[] shooterdamage = new int[]{20, 10, 0, 100000, 30};

    public String[] getAttacks(Classes classes){
        if(classes.getClass().equals("knight")){
            return knightattacks;

        } else if(classes.getClass().equals("mage")){
            return mageattacks;

        } else if(classes.getClass().equals("archer")){
            return archerattacks;

        } else if(classes.getClass().equals("bard")){
            return bardattacks;

        } else if(classes.getClass().equals("shooter")){
            return shooterattacks;

        }
        return null;
    }

    public int[] getAttackDamage(Classes classes){
        if(classes.getClass().equals("knight")){
            return knightdamage;

        } else if(classes.getClass().equals("mage")){
            return magedamage;

        } else if(classes.getClass().equals("archer")){
            return archerdamage;

        } else if(classes.getClass().equals("bard")){
            return barddamage;

        } else if(classes.getClass().equals("shooter")){
            return shooterdamage;

        }
        return null;
    }
}
