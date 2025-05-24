package hust.soict.hedspi.aims.screen.customer.controller; // Or your actual package for ItemController

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable; // Assuming Playable is in this package or imported
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox; // Assuming HBox might be an @FXML field or used statically
import javafx.geometry.Insets;

public class ItemController {
    private Media media;
    private Cart cart;
    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;
    @FXML
    private Button btnPlay;
    public ItemController(Cart cart) {
        this.cart = cart;
    }
    @FXML
    private Button btnAddToCart;

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}
