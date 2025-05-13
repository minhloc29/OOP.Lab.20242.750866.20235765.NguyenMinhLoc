package hust.soict.hedspi.aims.media;
import java.util.UUID;
import java.util.Comparator;

public class Media {
    protected String title;
    protected String category;
    protected float cost;
    protected String id;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isMatch(String title){
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    public String toString(){
        String message = "Product - " + this.title + " - " + this.category + ": " + this.cost + " $";
        return message;
    }
}

