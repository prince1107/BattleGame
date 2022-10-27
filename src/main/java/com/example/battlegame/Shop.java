package com.example.battlegame;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Random;

public class Shop {
    private Items[] itemList;

    public Shop(Items[] itemList){
        this.itemList = itemList;
    }

    protected void randomizeShop(ListView listView){
        ArrayList<String> tempList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int index = random.nextInt(itemList.length);
            tempList.add(itemList[index].getName());
        }

        listView.getItems().clear();
        listView.getItems().addAll(tempList);
    }

}
