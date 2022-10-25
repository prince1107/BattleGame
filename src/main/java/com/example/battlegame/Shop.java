package com.example.battlegame;

import java.util.ArrayList;
import java.util.Random;

public class Shop {
    private ArrayList<Items> itemList = new ArrayList<>();

    public Shop(ArrayList itemList){
        this.itemList = itemList;
    }

    protected void randomizeShop(){
        ArrayList<Items> tempList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int index = random.nextInt(itemList.size());
            tempList.add((itemList.get(index)));
        }
    }

}
