package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
        super(title, category, director, length, cost, id);
        nbDigitalVideoDiscs++;
    }

//    public DigitalVideoDisc(String title, String category, float cost, int id) {
//        super(title, category, cost, id);
//        nbDigitalVideoDiscs++;
//    }


//    public String getTitle() {
//        return this.title;
//    }

//    public String getCategory() {
//        return this.category;
//    }

    public String getDirector() {
        return this.director;
    }

    public float getLength() {
        return this.length;
    }

//    public float getCost() {
//        return this.cost;
//    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String toString(){
        String message = "DVD - " + this.title + " - " + this.category + " - " + this.director + " - " + this.length + ": " + this.cost + " $";
        return message;
    }

    public boolean isMatch(String title){
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}