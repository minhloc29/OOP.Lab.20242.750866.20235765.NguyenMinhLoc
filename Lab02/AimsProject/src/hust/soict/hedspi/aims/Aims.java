package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.cart.Cart;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger", 87, 19.95f, 1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Minh Loc", "Horror", "Peter", 50, 14.95f, 2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Louis", "Animation", "Viruss", 87, 19.95f, 3);
        anOrder.addDigitalVideoDisc(dvd1);
//        anOrder.display();
        anOrder.addDigitalVideoDisc(dvd2, dvd3);
//        anOrder.display();
        anOrder.displayOrdered();

        Book bk = new Book(1, "The Windmill", "Fiction", 12.34f);
        bk.addAuthor("John Smith");


    }
}