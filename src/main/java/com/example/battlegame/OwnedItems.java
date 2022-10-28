package com.example.battlegame;

public class OwnedItems {
    private Items item;

    private int numItems;

    public OwnedItems(Items item){
        this.item = item;

        numItems = 1;
    }

    public Items getItem() {
        return item;
    }

    public int getNumItems() {
        return numItems;
    }

    public void changeNumItems(int numItems) {
        this.numItems += numItems;
    }
}
