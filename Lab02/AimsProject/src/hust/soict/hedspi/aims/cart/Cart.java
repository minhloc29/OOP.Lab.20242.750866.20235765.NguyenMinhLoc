package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import java.util.LinkedList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERS = 20;
    private int qtyOrdered = 0;
    LinkedList<DigitalVideoDisc> itemsOrdered = new LinkedList();

    public Cart() {
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered >= 20) {
            System.out.println("The cart is full!");
        }
        else {
            this.itemsOrdered.add(disc);
            ++this.qtyOrdered;
            System.out.println("The disc has been added.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        this.itemsOrdered.remove(disc);
        --this.qtyOrdered;
        System.out.println("Remove successfully!");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc... discs) {
        for(DigitalVideoDisc disc : discs) {
            this.addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }

    public float totalCost() {
        float total = 0.0f;

        for(DigitalVideoDisc disc : this.itemsOrdered) {
            total += disc.getCost();
        }

        return total;
    }

    public void display() {
        int index = 1;

        for(DigitalVideoDisc disc : this.itemsOrdered) {
            System.out.printf("%d\t%s\t%.2f\n", index, disc.getTitle(), disc.getCost());
            ++index;
        }

        System.out.printf("\tTotal Cost: %.2f\n", this.totalCost());
    }

    public void displayOrdered() {
        int index = 1;
        System.out.println("**********CART**********");
        System.out.println("Ordered Items: ");
        for(DigitalVideoDisc disc : this.itemsOrdered) {
            String message = disc.toString();
            message = index + ". " + message;
            System.out.println(message);
            index ++;
        }
        System.out.printf("Total cost: %.2f\n", this.totalCost());
        System.out.println("************************");
    }

    public void searchDVD(String title){
        for(DigitalVideoDisc disc: this.itemsOrdered){
            if (disc.isMatch(title)){
                String message = disc.toString();
                System.out.println(message);
                return;
            }
        }
        System.out.println("No such title found!");
    }
}