package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
    private JTextField authorField;
    private StoreManagerScreen managerScreen;
    public AddBookToStoreScreen(Store store, StoreManagerScreen managerScreen){
        super(store);
        this.managerScreen = managerScreen;
        setTitle("Add Book");
    }
    @Override
    protected void addCustomFields(JPanel panel) {
        authorField = new JTextField(10);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
    }

    @Override
    protected void handleSubmit() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String author = authorField.getText();

        Book book = new Book(title, category, cost);
        book.addAuthor(author);

        store.addMedia(book);
        this.managerScreen.updateCenterPanel();
        dispose();  // Close the window after submission
    }
}
