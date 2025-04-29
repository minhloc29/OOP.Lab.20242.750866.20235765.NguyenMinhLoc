package hust.soict.hedspi.lab02.AimsProject.src;

public class Main {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Minh Loc", "Horror", "Peter", 50, 14.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Louis", "Animation", "Viruss", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.display();
        anOrder.addDigitalVideoDisc(dvd2, dvd3);
        anOrder.display();
    }
}