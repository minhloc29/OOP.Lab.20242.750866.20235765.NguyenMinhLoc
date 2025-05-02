package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
        super(title, category, director, length, cost, id);
        nbDigitalVideoDiscs++;
    }

    public String getDirector() {
        return this.director;
    }

    public float getLength() {
        return this.length;
    }

    public boolean isMatch(String title){
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}