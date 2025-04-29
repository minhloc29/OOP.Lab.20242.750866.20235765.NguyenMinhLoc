package hust.soict.hedspi.lab02.AimsProject.src;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderelDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderelDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderelDVD.getTitle());

        changeTitle(jungleDVD, cinderelDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());

    }

    public static void swap(Object obj1, Object obj2) {
        Object temp = obj1;
        obj1 = obj2;
        obj2 = temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}