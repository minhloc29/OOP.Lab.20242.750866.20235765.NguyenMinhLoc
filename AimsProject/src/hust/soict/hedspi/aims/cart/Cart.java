package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERS = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public Cart() {
    }

    public void addMedia(Media med) {
        this.itemsOrdered.add(med);
        System.out.println("The media has been added.");

    }

    public void removeMedia(Media med) {
        this.itemsOrdered.remove(med);
        System.out.println("Remove successfully!");
    }

    public void addMedia(Media... medias) {
        for(Media med : medias) {
            this.addMedia(med);
        }
    }

    public void addMedia(Media med1, Media med2){
        this.addMedia(med1);
        this.addMedia(med2);
    }

    public float totalCost() {
        float total = 0.0f;

        for(Media med : this.itemsOrdered) {
            total += med.getCost();
        }

        return total;
    }

    public void display() {
        int index = 1;

        for(Media med : this.itemsOrdered) {
            System.out.printf("%d\t%s\t%.2f\n", index, med.getTitle(), med.getCost());
            ++index;
        }

        System.out.printf("\tTotal Cost: %.2f\n", this.totalCost());
    }

    public void displayOrdered() {
        int index = 1;
        System.out.println("**********CART**********");
        System.out.println("Ordered Items: ");
        for(Media med : this.itemsOrdered) {
            String message = med.toString();
            message = index + ". " + message;
            System.out.println(message);
            index ++;
        }
        System.out.printf("Total cost: %.2f\n", this.totalCost());
        System.out.println("************************");
    }

    public void searchMedia(String title){
        for(Media med: this.itemsOrdered){
            if (med.isMatch(title)){
                String message = med.toString();
                System.out.println(message);
                return;
            }
        }
        System.out.println("No such title found!");
    }
    public ArrayList<Media> getItemsOrdered(){
        return this.itemsOrdered;
    }
}