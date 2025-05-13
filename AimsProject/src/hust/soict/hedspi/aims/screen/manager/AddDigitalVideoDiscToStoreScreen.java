package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
    private JTextField directorField;
    private JTextField lengthField;
    private StoreManagerScreen managerScreen;
    public AddDigitalVideoDiscToStoreScreen(Store store, StoreManagerScreen managerScreen){
        super(store);
        this.managerScreen = managerScreen;
        setTitle("Add Digital Video Disc");
    }
    @Override
    protected void addCustomFields(JPanel panel) {
        directorField = new JTextField(10);
        lengthField = new JTextField(10);
        panel.add(new JLabel("Director: "));
        panel.add(directorField);
        panel.add(new JLabel("Length: "));
        panel.add(lengthField);
    }

    @Override
    protected void handleSubmit() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String director = directorField.getText();
        float length = Float.parseFloat(lengthField.getText());

        DigitalVideoDisc disc = new DigitalVideoDisc(title, category, director, length, cost);

        store.addMedia(disc);
        this.managerScreen.updateCenterPanel();
        dispose();  // Close the window after submission
    }
}
