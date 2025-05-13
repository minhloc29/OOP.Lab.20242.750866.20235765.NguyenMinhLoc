package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CartTest {
    public static void main(String[] args) {
//        Cart cart = new Cart();
//        Store store = new Store();
//        CompactDisc cd = new CompactDisc("Adam", "Fiction", "Will Pond", 14, 13.26f, 1);
//        DigitalVideoDisc dvd = new DigitalVideoDisc("Lion King", "Animation", "Roger", 87, 19.95f, 1);
//        Book bk = new Book(1, "Pi's Life", "Fiction", 12.30f);
//
//        List<Media> medias = new ArrayList<Media>();
//        medias.add(cd);
//        medias.add(dvd);
//        medias.add(bk);
//
//        for (Media media : medias) {
//
//            store.addMedia(media);
//            cart.addMedia(media);
//        }
//
//        Collections.sort(store.getItemsInStore(), Media.COMPARE_BY_COST_TITLE);
//        for (Media media : store.getItemsInStore()) {
//            String message = media.toString();
//            System.out.println(message);
//        }
//        String s = "Hello World!";
//        System.out.println(System.identityHashCode(s));
//        s = s + "hhihi";
//        System.out.println(System.identityHashCode(s));
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(System.identityHashCode(sb));
        sb.append("World");
        System.out.println(System.identityHashCode(sb));

    }

}