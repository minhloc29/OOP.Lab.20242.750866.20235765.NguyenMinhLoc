package product;

public class Product {
    private String id;
    private String name;
    private int stockQuantity;
    private double buyingPrice;
    private double sellingPrice;
    private String imageUrl;
    public Product() {
    }

    public Product(String id, String name, int stockQuantity, double buyingPrice, double sellingPrice, String imageUrl) {
        this.id = id;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getImageUrl() {return imageUrl;}

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getInfo() {
        return "ID: " + this.id + "\nName: " + this.name + "\nStock Quantity " + this.stockQuantity + "\nBuying Price: " + this.buyingPrice + "\nSelling Price: " + this.sellingPrice + "\nImage URL: " + this.imageUrl;
    }

    public void increaseStock(int amount) {
        if (amount < 0) {
            return;
        }
        this.stockQuantity += amount;
    }

    public void decreaseStock(int amount) {
        if (this.stockQuantity - amount < 0) {
            return;
        }
        this.stockQuantity -= amount;
    }

}
