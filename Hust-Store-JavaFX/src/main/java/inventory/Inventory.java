package inventory;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();

    public Inventory() {
    }

    public Inventory(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProductById(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public void updateProductStock(String productID, int quantity) {
        for (Product product : products) {
            if (product.getId().equals(productID)) {
                product.setStockQuantity(quantity);
            }
        }
    }

    public void updateProductSellingPrice(String productID, double newSellingPrice) {
        for (Product product : products) {
            if (product.getId().equals(productID)) {
                product.setSellingPrice(newSellingPrice);
            }
        }
    }

    public Product searchProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void updateProductBuyingPrice(String productID, double newBuyingPrice) {
        for (Product product : products) {
            if (product.getId().equals(productID)) {
                product.setBuyingPrice(newBuyingPrice);
            }
        }
    }

}
