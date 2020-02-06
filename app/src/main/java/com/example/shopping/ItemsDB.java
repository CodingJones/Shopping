package com.example.shopping;

import java.util.ArrayList;
import java.util.List;

public class ItemsDB {

    private List<Item> ItemsDB;

    /**
     * Constructor method which creates an ArrayList.
     */
    public ItemsDB() {
        ItemsDB = new ArrayList<>();
    }

    /**
     * Listing all items in itemsDB
     * @return
     */
    public String listItems() {
        String r = "";
        for (int i = 0; i < ItemsDB.size(); i++) {
            r = r + "\n Buy " + ItemsDB.get(i).toString();
        }
        return r;
    }

    /**
     * Added items to list.
     */
    public void fillItemsDB() {
        ItemsDB.add(new Item("coffee", "Irma"));
        ItemsDB.add(new Item("carrots", "Netto"));
        ItemsDB.add(new Item("milk", "Netto"));
        ItemsDB.add(new Item("bread", "bakery"));
        ItemsDB.add(new Item("butter", "Irma"));
    }

    /**
     * Adding user input what to buy and where to buy item to List.
     * @param stringWhat
     * @param stringWhere
     */
    public void addItem(String stringWhat, String stringWhere) {
        ItemsDB.add(new Item(stringWhat, stringWhere));
    }


}