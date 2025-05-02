package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

    CompactDisc cd = new CompactDisc("Adam", "Fiction", "Will Pond", 14, 13.26f);
    DigitalVideoDisc dvd = new DigitalVideoDisc("Lion King", "Animation", "Roger", 87, 19.95F);
    Book bk = new Book("Pi's Life", "Fiction", 12.30f);

    List<Media> medias = new ArrayList<Media>();
    medias.add(cd);
    medias.add(dvd);
    medias.add(bk);

    for (Media media : medias) {

        store.addMedia(media);
        cart.addMedia(media);
    }

    showMenu();
    }

    public static void showMenu(){
        int choice;
        String mediaTitle;
        String mediaCategory;
        float mediaCost;
        int found;
        while(true) {

            System.out.println("AIMS: ");
            System.out.println("----------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("----------------------------");
            System.out.println("Please enter your choice: 0-1-2-3");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (Media media : store.getItemsInStore()) {
                        String message = media.toString();
                        System.out.println(message);
                        System.out.println("------------------------------------");
                    }
                    storeMenu();
                    break;
                case 2:
                    System.out.println("1. Add a media to the store");
                    System.out.println("2. Remove a media from the store");
                    System.out.println("Please enter your choice: 1-2");

                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if(choice == 2){
                        found = 0;
                        System.out.print("Enter media title to remove: ");
                        mediaTitle = scanner.nextLine();

                        for(Media media : store.getItemsInStore()){
                            if(media.isMatch(mediaTitle)){
                                store.removeMedia(media);
                                System.out.println("Removed item");
                                found = 1;
                                break;
                            }
                        }
                        if(found == 0){
                            System.out.println("Media not found!");
                        }
                    }
                    else if(choice == 1){
                        System.out.print("Enter media title: ");
                        mediaTitle = scanner.nextLine();
                        System.out.print("Enter media category: ");
                        mediaCategory = scanner.nextLine();
                        System.out.print("Enter media cost: ");
                        mediaCost = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print("Enter media id: ");

                        Media media = new Media(mediaTitle, mediaCategory, mediaCost);
                        store.addMedia(media);
                        System.out.println("Added item");
                    }
                    else{
                        System.out.println("Invalid choice!");
                    }
                    break;
                case 3:
                    cart.displayOrdered();
                    cartMenu();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void storeMenu(){
        while(true){


            System.out.println("Options: ");
            System.out.println("----------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("----------------------------");
            System.out.println("Please enter your choice: 0-1-2-3-4");

            int choice = scanner.nextInt();
            scanner.nextLine();
            int found;
            String mediaTitle;
            switch (choice) {
                case 1:
                    found = 0;
                    System.out.print("Enter media title: ");
                    mediaTitle = scanner.nextLine();
                    for (Media media : store.getItemsInStore()) {
                        if (media.isMatch(mediaTitle)) {
                            String message = media.toString();
                            System.out.print(message);
                            found = 1;
                            break;
                        }
                    }
                    if (found == 0) {
                        System.out.println("Media not found!");
                    }
                    mediaDetailsMenu();
                    break;
                case 2:
                    found = 0;
                    System.out.print("Enter media title: ");
                    mediaTitle = scanner.nextLine();
                    for (Media media : store.getItemsInStore()) {
                        if (media.isMatch(mediaTitle)) {
                            cart.addMedia(media);
                            found = 1;
                            break;
                        }
                    }
                    if (found == 0) {
                        System.out.println("Media not found!");
                    }
                    break;
                case 3:
                    found = 0;
                    System.out.print("Enter media title: ");
                    mediaTitle = scanner.nextLine();
                    for (Media media : store.getItemsInStore()) {
                        if (media.isMatch(mediaTitle)) {
                            found = 1;
                            break;
                        }
                    }
                    if (found == 0) {
                        System.out.println("Media not found!");
                    }
                    break;

                case 0:
                    System.out.println("Returning to the main menu");
                    return;

                default:
                    System.out.println("Invalid choice, try again!!");
                    break;
            }
        }
    }

    public static void mediaDetailsMenu(){
        System.out.println("Options: ");
        System.out.println("----------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("----------------------------");
        System.out.println("Please enter your choice: 0-1-2");
    }

    public static void cartMenu(){
        while(true){
            System.out.println("Options: ");
            System.out.println("----------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("----------------------------");
            System.out.println("Please enter your choice: 0-1-2-3-4-5");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    System.out.println("1. Filtering media by ID");
                    System.out.println("2. Filtering media by title");
                    System.out.println("Please enter your choice: 1-2");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if(choice == 1){
                        System.out.print("ID to filter: ");
                        int mediaID = scanner.nextInt();
                        scanner.nextLine();
                        for(Media media: cart.getItemsOrdered()){
                            if(media.getId().equals(mediaID)){
                                String message = media.toString();
                                System.out.println(message);
                                break;
                            }
                        }
                    }
                    else if(choice == 2){
                        System.out.print("Title to filter: ");
                        String mediaTitle = scanner.nextLine();
                        for(Media media: cart.getItemsOrdered()){
                            if(media.getTitle().contains(mediaTitle)){
                                String message = media.toString();
                                System.out.println(message);
                            }
                        }
                    }
                    else{
                        System.out.println("Invalid choice");
                    }
                    break;

                case 2:
                    System.out.println("1. Sort by cost");
                    System.out.println("2. Sort by title");
                    System.out.println("Please enter your choice: 1-2");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if(choice == 1){
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                    }
                    else if(choice == 2){
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                    }
                    else{
                        System.out.println("Invalid choice");
                    }
                    break;
                case 0:
                    System.out.println("Returning to the main menu");
                    return;

                case 5:
                    System.out.println("Order has been made");
                    cart.getItemsOrdered().clear();
                    break;

                default:
                    System.out.println("Invalid choice, try again!!");
                    break;
            }
        }
    }
}