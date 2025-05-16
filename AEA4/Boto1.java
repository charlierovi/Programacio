package AEA4;

import javax.swing.*;

public class Boto1 {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("1 Button");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 

        JButton button = new JButton("Click");
        button.setBounds(100, 70, 80, 30); 

        frame.add(button);

        frame.setVisible(true);
    }
}


