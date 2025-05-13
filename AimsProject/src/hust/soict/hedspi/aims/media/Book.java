package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
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
        StringBuffer sb = new StringBuffer();
        sb.append("Book Information:\n");
        sb.append("Title: ").append(this.title).append("\n");
        sb.append("Category: ").append(this.category).append("\n");
        sb.append("Author List: ");

        if (authors.size() > 0) {
            for (int i = 0; i < authors.size() - 1; i++) {
                sb.append(authors.get(i)).append(" - ");
            }
            sb.append(authors.get(authors.size() - 1));
        } else {
            sb.append("No authors");
        }

        sb.append("\nCost: ").append(String.format("%.2f $", this.cost));

        return sb.toString();
    }
}
