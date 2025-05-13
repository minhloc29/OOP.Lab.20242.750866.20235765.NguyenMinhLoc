package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAccumulator extends JFrame{
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator(){
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setLayout(new GridLayout(2,2));

        c.add(new JLabel("Input:"));

        tfInput = new JTextField(10);
        c.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        c.add(new JLabel("Output:"));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        c.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args){
        new SwingAccumulator();
    }
    public class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
