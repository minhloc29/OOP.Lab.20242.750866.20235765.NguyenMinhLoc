package screen.customer.store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Store extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Working directory: " + System.getProperty("user.dir"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/customer/fxml/login-signup.fxml"));
        Parent root = loader.load();
        Scene mainScene = new Scene(root);
        stage.setTitle("Hust Book Store");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}