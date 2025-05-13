package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    protected JTextField titleField;
    protected JTextField categoryField;
    protected JTextField costField;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add Item");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel inputPanel = createInputPanel();
        JButton submitButton = new JButton("Add");

        submitButton.addActionListener(e -> handleSubmit());

        add(inputPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    protected JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2));

        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();

        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);

        addCustomFields(panel); // subclass-specific fields
        return panel;
    }

    protected abstract void addCustomFields(JPanel panel);

    protected abstract void handleSubmit();
}
