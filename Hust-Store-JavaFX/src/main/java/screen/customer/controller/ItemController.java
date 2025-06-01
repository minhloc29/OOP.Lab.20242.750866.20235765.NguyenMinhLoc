package screen.customer.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import product.Book;
import product.Product;

public class ItemController {
    @FXML
    private ImageView productImageView;

    @FXML
    private Label originalPriceLabel;

    @FXML
    private VBox productItemRoot;
    @FXML
    private Label productAuthorLabel;

    @FXML
    private Label productNameLabel;
    public void setData(Product product) {
        productNameLabel.setText(product.getName());
        Image image = new Image(product.getImageUrl(), true);
        image.exceptionProperty().addListener((obs, oldEx, newEx) -> {
            if (newEx != null) {
                System.err.println("Failed to load image: " + newEx.getMessage());
            }
        });
        productImageView.setImage(image);
        originalPriceLabel.setText(String.format("%.3f₫", product.getSellingPrice()));
        if(product instanceof Book){
            Book book = (Book) product;
            productAuthorLabel.setText(book.getAuthor());
        }

    }
}
