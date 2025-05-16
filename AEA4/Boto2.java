package AEA4;
import java.awt.*;
import javax.swing.*;

public class Boto2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("2 Buttons");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 

        JButton blueButton = new JButton("Click");
        blueButton.setBounds(90, 50, 100, 30);
        blueButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        blueButton.setBackground(new Color(230, 230, 230));
        blueButton.setForeground(new Color(0, 0, 128));
        blueButton.setOpaque(true);
        blueButton.setBorderPainted(true);

        JButton redButton = new JButton("Clic aquí");
        redButton.setBounds(75, 120, 130, 40);
        redButton.setFont(new Font("Arial", Font.BOLD, 13));
        redButton.setBackground(Color.RED);
        redButton.setForeground(Color.WHITE);
        redButton.setOpaque(true);
        redButton.setBorderPainted(false);
        redButton.setFocusPainted(false);

        frame.add(blueButton);
        frame.add(redButton);

        frame.setVisible(true);
    }
}
