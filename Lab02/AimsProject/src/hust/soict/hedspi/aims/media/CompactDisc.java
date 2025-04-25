package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return this.artist;
    }

    public CompactDisc(String title, String category, String director, int length, float cost, int id) {
        super(title, category, director, length, cost, id);
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
}
