package com.example.battlegame;

import javafx.scene.image.Image;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

public class Classes {
    private String className;

    private double[] attributeChanges;//Strength, Speed, Health, Defense

    private ArrayList<Attack> attacks = new ArrayList<>();

    private Image image;

    public Classes(String className){
        this.className = className;
        if(className.equals("knight")){
            image = new Image(getClass().getResource("knightlogo.jpg").toString());

            this.attributeChanges = new double[]{20,-5,0,10};

            attacks.add(new Attack("Piercing Stab", 15));
            attacks.add(new Attack("Slice", 5));
            attacks.add(new Attack("Strength++", 0));
            attacks.add(new Attack("Lance Dash", 20));
            attacks.add(new Attack("Sweep & Slice", 10));
            attacks.add(new Attack("Flee", 0));

        } else if(className.equals("mage")){
            image = new Image(getClass().getResource("magelogo.jpeg").toString());

            this.attributeChanges = new double[]{-10,15,70,0};

            attacks.add(new Attack("Fire Rain", 30));
            attacks.add(new Attack("Shadow Slice", 25));
            attacks.add(new Attack("Health++", 0));
            attacks.add(new Attack("Sun Spear", 35));
            attacks.add(new Attack("Water Whip", 10));
            attacks.add(new Attack("Flee", 0));

        } else if(className.equals("archer")){
            image = new Image(getClass().getResource("archerlogo.jpeg").toString());

            this.attributeChanges = new double[]{-10,25,0,10};

            attacks.add(new Attack("Piercing Arrows", 10));
            attacks.add(new Attack("Exploding Arrows", 25));
            attacks.add(new Attack("Speed++", 0));
            attacks.add(new Attack("Loudest Arrows", 10));
            attacks.add(new Attack("Multishot", 20));
            attacks.add(new Attack("Flee", 0));

        } else if(className.equals("bard")){
            image = new Image(getClass().getResource("bardlogo.png").toString());

            this.attributeChanges = new double[]{20,-5,-40,10};

            attacks.add(new Attack("Bagpipe Shriek", 5));
            attacks.add(new Attack("Flute Slice", 10));
            attacks.add(new Attack("Health Song", 0));
            attacks.add(new Attack("Xylophone Confusion", 5));
            attacks.add(new Attack("Speed Song", 15));
            attacks.add(new Attack("Flee", 0));

        } else if(className.equals("shooter")){
            image = new Image(getClass().getResource("shooterlogo.jpeg").toString());

            this.attributeChanges = new double[]{-10,-5,-30,10};

            attacks.add(new Attack("Piercing Bullets", 20));
            attacks.add(new Attack("Bayonet Slice", 10));
            attacks.add(new Attack("Speed++", 0));
            attacks.add(new Attack("Snipe", 50, 5));
            attacks.add(new Attack("MultiShot", 30));
            attacks.add(new Attack("Flee", 0));

        } else if(className.equals("boss1")){
            image = new Image(getClass().getResource("boss1.png").toString());

            this.attributeChanges = new double[]{10,10,10,10};

            attacks.add(new Attack("The Stomper", 40));
            attacks.add(new Attack("Crazy Slice", 20));
            attacks.add(new Attack("Jump Scare", 10));
            attacks.add(new Attack("Weaken", 0));
            attacks.add(new Attack("Weaken", 0));

        } else if(className.equals("boss2")){
            image = new Image(getClass().getResource("boss2.png").toString());

            this.attributeChanges = new double[]{20,20,20,20};

            attacks.add(new Attack("Fire Spin", 20));
            attacks.add(new Attack("Incinerator", 40));
            attacks.add(new Attack("Missile Attack", 30));
            attacks.add(new Attack("Slow", 0));
            attacks.add(new Attack("Slow", 0));

        }
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public double[] getAttributeChanges() {
        return attributeChanges;
    }

    public String getClassName() {
        return className;
    }

    public Image getImage() {
        return image;
    }
}
