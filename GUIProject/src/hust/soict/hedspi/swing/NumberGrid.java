package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        // Create and configure the display text field
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Create panel with GridLayout for number buttons
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        // Set up the content pane layout and add components
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        // Configure the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        // Add buttons 1–9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Add Delete button
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Add 0 button
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Add Reset button
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();

            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                // Append number to the display
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                // Remove the last character from the display if any
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else {
                // Handle "C" case: clear the display
                tfDisplay.setText("");
            }
        }
    }
}
