package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2){
        int costCompare = Double.compare(m1.getCost(), m2.getCost());
        if (costCompare == 0) {
            return m1.getTitle().toLowerCase().compareTo(m2.getTitle().toLowerCase());
        }
        return costCompare;
    }
}
