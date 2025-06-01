package product;

public class Toy extends Product {
    private String brand;
    private int ageRecommendation;

    public Toy() {
    }

    public Toy(String id, String name, int stockQuantity, double buyingPrice, double sellingPrice, String brand, int ageRecommendation, String imageUrl) {
        super(id, name, stockQuantity, buyingPrice, sellingPrice, imageUrl);
        this.brand = brand;
        this.ageRecommendation = ageRecommendation;
    }

    public String getBrand() {
        return brand;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }

    public String getInfo() {
        return super.getInfo() + "\nBrand: " + this.brand + "\nAge Recommendation: " + this.ageRecommendation;
    }

}
