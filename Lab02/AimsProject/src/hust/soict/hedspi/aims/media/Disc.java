package hust.soict.hedspi.aims.media;

public class Disc extends Media{
    protected float length;
    protected String director;

    public Disc(String title, String category, String director, int length, float cost, int id) {
        super(title, category, cost, id);
        this.length = length;
        this.director = director;
    }
}
