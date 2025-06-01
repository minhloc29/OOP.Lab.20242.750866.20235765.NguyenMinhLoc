module com.example.huststorejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens screen.customer to javafx.fxml;
    //exports screen.customer;
    exports screen.customer.store;
    opens screen.customer.store to javafx.fxml;
    exports screen.customer.controller;
    opens screen.customer.controller to javafx.fxml;
}