package com.example.battlegame;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<OwnedItems> itemsOwned = new ArrayList<>();

    public void addItem(OwnedItems ownedItems) {
        itemsOwned.add(ownedItems);
    }

    public void setItem(OwnedItems newItem, OwnedItems oldItem) {
        itemsOwned.remove(oldItem);
        itemsOwned.add(newItem);
    }

    public void removeItem(OwnedItems ownedItems) {
        itemsOwned.remove(ownedItems);
    }

    public ArrayList<OwnedItems> getItemsOwned() {
        return itemsOwned;
    }
}
