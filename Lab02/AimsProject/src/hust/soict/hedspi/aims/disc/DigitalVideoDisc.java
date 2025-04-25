package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDirector() {
        return this.director;
    }

    public int getLength() {
        return this.length;
    }

    public float getCost() {
        return this.cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        String message = "DVD - " + this.title + " - " + this.category + " - " + this.director + " - " + this.length + ": " + this.cost + " $";
        return message;
    }

    public boolean isMatch(String title){
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}