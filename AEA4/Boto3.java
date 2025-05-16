package AEA4;
import javax.swing.*;

public class Boto3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lenguajes");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 

        JLabel label = new JLabel("Lenguajes:");
        label.setBounds(20, 10, 100, 20);

        JRadioButton javaBtn = new JRadioButton("Java");
        javaBtn.setBounds(20, 35, 100, 20);
        javaBtn.setEnabled(false);  

        JRadioButton phpBtn = new JRadioButton("Php");
        phpBtn.setBounds(20, 60, 100, 20);
        phpBtn.setEnabled(false);   

        JRadioButton cppBtn = new JRadioButton("C++");
        cppBtn.setBounds(20, 85, 100, 20);
        cppBtn.setEnabled(false);   

        ButtonGroup group = new ButtonGroup();
        group.add(javaBtn);
        group.add(phpBtn);
        group.add(cppBtn);

        JButton validarBtn = new JButton("Validar");
        validarBtn.setBounds(20, 120, 100, 25);
        validarBtn.setEnabled(false); 

        frame.add(label);
        frame.add(javaBtn);
        frame.add(phpBtn);
        frame.add(cppBtn);
        frame.add(validarBtn);

        frame.setVisible(true);
    }
}

