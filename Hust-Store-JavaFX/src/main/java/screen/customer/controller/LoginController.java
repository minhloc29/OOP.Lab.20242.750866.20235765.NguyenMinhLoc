package screen.customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import user.PasswordHelper;
import user.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {
    private final PasswordHelper passwordHelper = new PasswordHelper();
    private static final Map<String, User> userStore = new HashMap<>();

    @FXML
    private Button signupButton;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private TextField signupUsernameField;

    @FXML
    private StackPane rootPane;

    @FXML
    private VBox loginPane;

    @FXML
    private VBox signupPane;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField signupConfirmPasswordField;

    @FXML
    private TextField loginUsernameField;

    @FXML
    private PasswordField signupPasswordField;

    @FXML
    void handleCreateAccount(ActionEvent event) {
        String username = signupUsernameField.getText();
        String password = signupPasswordField.getText();
        String confirmPassword = signupConfirmPasswordField.getText();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Signup Error", "All fields are required.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Signup Error", "Passwords do not match.");
            return;
        }

        if (userStore.containsKey(username)) {
            showAlert(Alert.AlertType.ERROR, "Signup Error", "Username already exists.");
            return;
        }
        try{
            User newUser = new User(username, username, null, null, password);
            userStore.put(username, newUser);
            showAlert(Alert.AlertType.INFORMATION, "Signup Successful", "Account created for " + username);
            System.out.println("User created: " + username + ". User object stored (demo).");
            // Move to main store page
            Stage stage = (Stage) signupButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/customer/fxml/viewstore.fxml"));
            Parent root = loader.load();
            Scene mainScene = new Scene(root);
            stage.setTitle("Hust Book Store");
            stage.setScene(mainScene);
            stage.show();

        }
        catch (Exception e){
            showAlert(Alert.AlertType.ERROR, "Signup Error", "Error creating account: " + e.getMessage());
            e.printStackTrace(); // Log the full error
        }
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String username = loginUsernameField.getText();
        String password = loginPasswordField.getText();
        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Login Error", "All fields are required.");
            return;
        }
        if (userStore.containsKey(username)) {
            User user = userStore.get(username);
            if (!password.equals(user.getPassword())) {
                showAlert(Alert.AlertType.ERROR, "Login Error", "Passwords do not match.");
            }
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Login Successful");
            Stage stage = (Stage) signupButton.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/customer/fxml/viewstore.fxml"));
            Parent root = loader.load();
            Scene mainScene = new Scene(root);
            stage.setTitle("Hust Book Store");
            stage.setScene(mainScene);
            stage.show();
        }
        else{
            showAlert(Alert.AlertType.ERROR, "Login Error", "Account does not exist.");
            return;
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null); // No header
        alert.setContentText(message);
        alert.initOwner(rootPane.getScene().getWindow()); // Optional: makes the alert modal to this window
        alert.showAndWait();
    }
    @FXML
    private void showSignupPane() {
        loginPane.setVisible(false);
        signupPane.setVisible(true);
    }

    @FXML
    private void showLoginPane() {
        signupPane.setVisible(false);
        loginPane.setVisible(true);
    }

}
