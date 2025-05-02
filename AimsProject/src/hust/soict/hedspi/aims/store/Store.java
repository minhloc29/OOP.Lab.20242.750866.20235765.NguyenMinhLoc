package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Store {
    private static final int MAX_ITEMS = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private int quantity = 0;

    public void addMedia(Media med){
        if(quantity == MAX_ITEMS){
            System.out.println("Warning: Maximum number of items reached");
            return;
        }
        itemsInStore.add(med);
        quantity++;
        System.out.println("Added new item");
    }

    public void removeMedia(Media med){
        if(!itemsInStore.contains(med)){
            System.out.println("Warning: The media does not exist");
            return;
        }
        itemsInStore.remove(med);
        System.out.println("Removed item");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}