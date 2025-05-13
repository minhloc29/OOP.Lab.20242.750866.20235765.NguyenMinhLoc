package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media m1, Media m2){
        int titleCompare = m1.getTitle().toLowerCase().compareTo(m2.getTitle().toLowerCase());
        if (titleCompare == 0){
            return Double.compare(m1.getCost(), m2.getCost());
        }
        return titleCompare;
    }
}
