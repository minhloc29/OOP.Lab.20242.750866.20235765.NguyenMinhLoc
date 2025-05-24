package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return this.artist;
    }

    public CompactDisc(String title, String category, String director, float length, float cost) {
        super(title, category, director, length, cost);
    }

    public void addTrack(Track track) {
        if(!this.tracks.contains(track)){
            this.tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
            return;
        }
        System.out.println("Track already added: " + track.getTitle());
    }

    public void removeTrack(Track track) {
        if(this.tracks.contains(track)){
            this.tracks.remove(track);
            System.out.println("Removed track: " + track.getTitle());
            return;
        }
        System.out.println("Track does not exist: " + track.getTitle());
    }

    public float getLength(){
        float length = 0;
        for(Track track : tracks){
            length += track.getLength();
        }
        return length;
    }

    public String toString(){
        String message = "CD Information:\n" +
                "Title: " + this.title + "\n" +
                "Category: " + this.category + "\n" +
                "Artist: " + this.artist + "\n" +
                "Director: " + this.director + "\n" +
                "Length: " + this.length + "\n" +
                "Cost: " + String.format("%.2f $", this.cost);

        return message;
    }

    public void play() throws PlayerException{
        if (this.getLength() > 0) {
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack = null;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                }
                catch (PlayerException e) {
                    throw e;
                }
            }
        }
        else{
            throw new PlayerException("ERROR: DVD is non-positive!");
        }
    }
}
