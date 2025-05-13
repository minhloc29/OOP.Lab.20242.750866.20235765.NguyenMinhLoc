package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField artistField;
    private JTextField directorField;
    private JTextField lengthField;
    private StoreManagerScreen managerScreen;
    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen managerScreen){
        super(store);
        this.managerScreen = managerScreen;
        setTitle("Add Compact Disc");
    }
    @Override
    protected void addCustomFields(JPanel panel) {
        artistField = new JTextField(10);
        directorField = new JTextField(10);
        lengthField = new JTextField(10);
        panel.add(new JLabel("Artist:"));
        panel.add(artistField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        panel.add(new JLabel("Length:"));
        panel.add(lengthField);
    }

    @Override
    protected void handleSubmit() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String artist = artistField.getText();
        String director = directorField.getText();
        float length = Float.parseFloat(lengthField.getText());

        CompactDisc disc = new CompactDisc(title, category, director, length, cost);

        store.addMedia(disc);
        this.managerScreen.updateCenterPanel();
        dispose();  // Close the window after submission
    }
}
