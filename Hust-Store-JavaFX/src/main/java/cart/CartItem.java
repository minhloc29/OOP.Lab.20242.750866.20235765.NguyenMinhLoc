package cart;

import product.Product;

public class CartItem {
    private Product product;
    private int quantity;
    private double unitPrice;

    public CartItem() {
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Product product, int quantity, double unitPrice) {
        this(product, quantity);
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0)
            this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return quantity * unitPrice;
    }

}
