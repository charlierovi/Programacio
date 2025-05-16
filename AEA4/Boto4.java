package AEA4;
import java.awt.*;
import javax.swing.*;

public class Boto4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTextField emailField = new JTextField("Escribe tu E-Mail");
        emailField.setBounds(50, 20, 200, 30);
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        emailField.setForeground(Color.GRAY);
        emailField.setEditable(false);
        emailField.setDisabledTextColor(Color.GRAY);
        emailField.setEnabled(false);  

        JTextField nameField = new JTextField("First Name please");
        nameField.setBounds(50, 70, 400, 50);
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        nameField.setForeground(new Color(150, 150, 255)); 
        nameField.setEditable(false);
        nameField.setDisabledTextColor(new Color(150, 150, 255));
        nameField.setEnabled(false); 

        frame.add(emailField);
        frame.add(nameField);
        frame.setVisible(true);
    }
}
