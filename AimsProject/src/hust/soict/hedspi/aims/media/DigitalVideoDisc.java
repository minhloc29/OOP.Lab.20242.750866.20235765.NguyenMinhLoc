package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title, String category, String director, float length, float cost) {
        super(title, category, director, length, cost);
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

    public String toString(){
        String message = "DVD Information:\n" +
                "Title: " + this.title + "\n" +
                "Category: " + this.category + "\n" +
                "Director: " + this.director + "\n" +
                "Length: " + this.length + "\n" +
                "Cost: " + String.format("%.2f $", this.cost);

        return message;
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
        else{
            throw new PlayerException("ERROR: DVD is non-positive!");
        }
    }
}