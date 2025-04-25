package hust.soict.hedspi.garbage;

public class GarbageCreator {
    public static void main(String[] args) {
        while(true) {
            String garbage = new String("Garbage" + Math.random());
        }
    }
}

