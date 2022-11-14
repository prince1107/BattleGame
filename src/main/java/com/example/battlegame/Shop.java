package com.example.battlegame;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Random;

public class Shop {
    private Items[] itemList;

    private ArrayList<Items> currentList = new ArrayList<>();

    public Shop(Items[] itemList){
        this.itemList = itemList;
    }

    protected void randomizeShop(ListView listView){
        ArrayList<String> tempList = new ArrayList<>();
        currentList.clear();

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int index = random.nextInt(itemList.length);
            tempList.add(itemList[index].getName() + "; Price: " + itemList[index].getShopPrice());
            currentList.add(itemList[index]);
        }

        listView.getItems().clear();
        listView.getItems().addAll(tempList);
    }

    public ArrayList<Items> getCurrentList() {
        return currentList;
    }
}
