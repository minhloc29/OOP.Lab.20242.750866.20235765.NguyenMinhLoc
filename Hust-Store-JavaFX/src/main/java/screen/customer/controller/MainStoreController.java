package screen.customer.controller; // Replace with your actual package name
import inventory.Inventory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import product.Book;
import product.Product;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import product.Stationary;
import product.Toy;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainStoreController implements Initializable {
    // private ObservableList<Product> masterProductList = FXCollections.observableArrayList();
    @FXML
    private BorderPane trangchuPane;

    @FXML
    private FlowPane productGridPane;

    private Inventory inventory;

    // Sample Product Data Structure

    private List<Product> allProducts = new ArrayList<>();
    private List<Product> books = new ArrayList<>();
    private List<Product> stationaries = new ArrayList<>();
    private List<Product> toys = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize ComboBoxes
        this.inventory = new Inventory();
        // Load sample products
        loadProductsToInventory();
        displayProducts(this.inventory.getProducts());
    }

    private void loadProductsToInventory() {
        InputStream bookFilePath = getClass().getResourceAsStream("/data/books.csv");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(bookFilePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] fields = line.split(";");
                if (fields.length == 12) {
                    try {
                        String isbn = fields[0].trim();
                        String title = fields[1].trim();
                        String author = fields[2].trim();
                        String publisher = fields[4].trim();
                        String imageUrl = fields[6].trim();
                        int quantity = Integer.parseInt(fields[8].trim());
                        double sellingPrice = Double.parseDouble(fields[9].trim());
                        double buyingPrice = Double.parseDouble(fields[11].trim());
                        String id = fields[10].trim();

                        Book book = new Book(id, title, quantity, buyingPrice, sellingPrice, author, publisher, isbn, imageUrl);
                        this.inventory.addProduct(book);
                        books.add(book);
                        System.out.println(book.getInfo());

                    } catch (Exception e) {
                        System.err.println("Error parsing line: " + line);
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Incorrect number of fields in line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        InputStream stationeryFilePath = getClass().getResourceAsStream("/data/stationary.csv");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(stationeryFilePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] fields = line.split(",");
                if (fields.length == 8) {
                    try {
                        String title = fields[1].trim();
                        String imageUrl = fields[7].trim();
                        int quantity = Integer.parseInt(fields[2].trim());
                        double sellingPrice = Double.parseDouble(fields[4].trim());
                        double buyingPrice = Double.parseDouble(fields[3].trim());
                        String id = fields[0].trim();
                        String brand = fields[5].trim();
                        String type = fields[6].trim();
                        Stationary stationary = new Stationary(id, title, quantity, buyingPrice, sellingPrice, brand, type, imageUrl);
                        this.inventory.addProduct(stationary);
                        stationaries.add(stationary);
                        System.out.println(stationary.getInfo());

                    } catch (Exception e) {
                        System.err.println("Error parsing line: " + line);
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Incorrect number of fields in line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    private void displayProducts(List<Product> productsToDisplay) {
        productGridPane.getChildren().clear(); // Clear existing products
        int numColumns = 3; // Define how many columns you want in your grid
        int currentRow = 0;
        int currentColumn = 0;

        for (Product product : productsToDisplay) {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/customer/fxml/Item.fxml"));
                Node productItemNode = loader.load();
                ItemController itemController = loader.getController();
                itemController.setData(product);
                productGridPane.getChildren().add(productItemNode);
            }
            catch(IOException e){
                System.err.println("Error loading Item.fxml for product: " + product.getName());
                e.printStackTrace();
            }
        }
    }

    private VBox createProductCard(Product product) {
        VBox card = new VBox();
        card.getStyleClass().add("product-card");
        card.setPrefWidth(220); // Matches CSS
        card.setSpacing(8);
        card.setAlignment(Pos.CENTER); // Center content within the card

        // Product Image
//        ImageView imageView = new ImageView();
//        try {
//            // Attempt to load the image.
//            // For local files, use: new Image(getClass().getResourceAsStream("/path/to/your/image.png"));
//            // For URLs: new Image(product.imageUrl, true); // true for background loading
//            Image productImage = new Image(product.imageUrl, 180, 140, true, true, true); // width, height, preserveRatio, smooth, backgroundLoading
//            imageView.setImage(productImage);
//        } catch (Exception e) {
//            // Fallback if image fails to load
//            Label imagePlaceholder = new Label("No Image");
//            imagePlaceholder.setStyle("-fx-background-color: #ECECEC; -fx-alignment: center; -fx-pref-height: 140px; -fx-pref-width: 180px;");
//            imageView.setFitHeight(140);
//            imageView.setFitWidth(180);
//            // Or, you could add the placeholder Label directly to the card instead of the ImageView
//            System.err.println("Failed to load image: " + product.imageUrl + " for product: " + product.name);
//        }
//        imageView.getStyleClass().add("product-image-view"); // Apply CSS class
//        VBox.setMargin(imageView, new Insets(0,0,5,0));


        // Product Name
        Label nameLabel = new Label(product.getName());
        nameLabel.getStyleClass().add("product-name");
        nameLabel.setWrapText(true);
        nameLabel.setAlignment(Pos.CENTER);
        nameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);


        // Product Price
        Label priceLabel = new Label(String.format("$%.2f", product.getSellingPrice()));
        priceLabel.getStyleClass().add("product-price");
        priceLabel.setAlignment(Pos.CENTER);

        // Add to Cart Button
        Button addButton = new Button("Add to Cart");
        addButton.getStyleClass().add("add-to-cart-button");
        addButton.setMaxWidth(Double.MAX_VALUE); // Make button take full width
        addButton.setOnAction(event -> handleAddToCart(product));

        // View Details Link (Optional)
        // Hyperlink detailsLink = new Hyperlink("View Details");
        // detailsLink.getStyleClass().add("details-link");
        // detailsLink.setOnAction(event -> handleViewDetails(product));

        card.getChildren().addAll(nameLabel, priceLabel, addButton /*, detailsLink */);
        return card;
    }

    @FXML
    private void handleAddToCart(Product product) {
        System.out.println("Added to cart: " + product.getName() + " (ID: " + product.getId() + ")");
        // Implement your actual add to cart logic here
        // e.g., update a shopping cart model, show a confirmation
        // showTemporaryMessage("Added " + product.getName() + " to cart!");
    }

    @FXML
    private void handleViewDetails(Product product) {
        System.out.println("Viewing details for: " + product.getName());
        // Implement logic to show a detailed product view
    }


    // Helper to show a temporary message (e.g., in a status bar or dialog)
    @FXML
    void handleBookSection(MouseEvent event) {
        displayProducts(books);
    }

    @FXML
    void handleStationarySection(MouseEvent event) {

        displayProducts(stationaries);
    }

    @FXML
    void handleToySection(MouseEvent event) {

    }
    @FXML
    void handleTrangchuSection(MouseEvent event) {

        displayProducts(this.inventory.getProducts());
    }
}
