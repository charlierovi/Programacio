package AEA4;

import java.awt.event.*;
import javax.swing.*;

public class Boto5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ComboBox Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        String[] languages = {"C", "C++", "C#", "Java", "PHP"};
        JComboBox<String> comboBox = new JComboBox<>(languages);
        comboBox.setBounds(40, 40, 100, 25);

        JLabel label = new JLabel("Programming language Selected: Java");
        label.setBounds(40, 10, 250, 20);

        JButton showButton = new JButton("Show");
        showButton.setBounds(160, 40, 80, 25);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                label.setText("Programming language Selected: " + selected);
            }
        });

        frame.add(comboBox);
        frame.add(showButton);
        frame.add(label);
        frame.setVisible(true);
    }
}
