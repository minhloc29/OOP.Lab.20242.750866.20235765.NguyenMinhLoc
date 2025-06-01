package product;

public class Book extends Product {
    private String author;
    private String publisher;
    private String isbn;

    public Book() {
    }

    public Book(String id, String name, int stockQuantity, double buyingPrice, double sellingPrice, String author, String publisher, String isbn, String imageUrl) {
        super(id, name, stockQuantity, buyingPrice, sellingPrice, imageUrl);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getInfo() {
        return super.getInfo() + "\nAuthor: " + this.author + "\nPublisher: " + this.publisher + "\nISBN: " + this.isbn;
    }

}
