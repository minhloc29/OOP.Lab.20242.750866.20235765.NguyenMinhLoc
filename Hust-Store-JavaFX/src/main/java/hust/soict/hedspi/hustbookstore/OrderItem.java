package hust.soict.hedspi.hustbookstore;

import product.Product;

public class OrderItem {
    private Product product;
    private int quantity;
    private double unitPrice;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public OrderItem(Product product, int quantity, double unitPrice) {
        this(product, quantity);
        this.unitPrice = unitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double calculateTotalPrice() {
        return quantity * unitPrice;
    }

}
