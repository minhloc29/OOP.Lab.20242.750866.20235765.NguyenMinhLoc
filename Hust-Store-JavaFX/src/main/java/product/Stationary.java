package product;

public class Stationary extends Product {
    private String brand;
    private String type;

    public Stationary() {
    }

    public Stationary(String id, String name, int stockQuantity, double buyingPrice, double sellingPrice, String brand, String type, String imageUrl) {
        super(id, name, stockQuantity, buyingPrice, sellingPrice, imageUrl);
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getInfo() {
        return super.getInfo() + "\nBrand: " + this.brand + "\nType: " + this.type;
    }

}
