package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(title, category, cost, id);
    }

    public void addAuthor(String authorName){
        if (!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println("Added author: " + authorName);
            return;
        }
        System.out.println("Already added author");
    }

    public void removeAuthor(String authorName){
        if (authors.contains(authorName)){
            System.out.println("Removing author: " + authorName);
            authors.remove(authorName);
            return;
        }
        System.out.println("No author found");

    }

    public String toString(){
        String message = "Book - " + this.title + " - " + this.category + ": " + this.cost + " $";
        return message;
    }
}
