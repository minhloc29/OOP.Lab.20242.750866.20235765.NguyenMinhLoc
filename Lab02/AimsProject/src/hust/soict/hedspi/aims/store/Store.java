package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
public class Store {
    private static final int MAX_ITEMS = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS];
    private int quantity = 0;

    public void addDVD(DigitalVideoDisc disc){
        if(quantity == MAX_ITEMS){
            System.out.println("Warning: Maximum number of items reached");
            return;
        }
        itemsInStore[quantity] = disc;
        quantity++;
        System.out.println("Added new item");
    }

    public void removeDVD(DigitalVideoDisc disc){
        for(int i = 0; i < quantity; i++){
            if(itemsInStore[i].equals(disc)) {
                for (int j = i; j < quantity - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[quantity - 1] = null;
                quantity--;
                return;
            }
        }
    }
}