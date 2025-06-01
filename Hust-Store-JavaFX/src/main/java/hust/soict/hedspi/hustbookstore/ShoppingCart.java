package hust.soict.hedspi.hustbookstore;

import cart.CartItem;
import product.Product;
import user.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart {
    private Customer customer;
    private final List<CartItem> cartItems = new ArrayList<>();
    private String cartId;
    private Date timeCreated;
    private int arttribute5; // ?? Không biết UML của anh như thế nào nhưng của tôi nó hiển thị như này:))

    public ShoppingCart() {
    }

    public void addItem(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        cartItems.add(cartItem);
    }

    public void removeItem(CartItem item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId().equals(item.getProduct().getId())) {
                cartItems.remove(cartItem);
            }
        }
    }

    public void updateItemQuantity(String productId, int newQuantity) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId().equals(productId)) {
                cartItem.setQuantity(newQuantity);
            }
        }
    }

    public void clearCart() {
        cartItems.clear();
    }

    public Order makeOrder() {
        //Order order = new Order(screen.customer);
        return null;
    }

}
