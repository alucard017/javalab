import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Frame1 {
    Frame1() {
        JFrame frame = new JFrame("Simple Swing Application");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new GridLayout(5, 2));
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        

        JLabel label = new JLabel("Username");
        frame.add(label);
        JTextField textField = new JTextField(20);
        frame.add(textField);

        JLabel label1 = new JLabel("Password");
        frame.add(label1);
        JTextField textField1 = new JTextField(20);
        frame.add(textField1);

        JLabel label2 = new JLabel("Your favorite language is ");

        JRadioButton radioButton = new JRadioButton("c++");
        JRadioButton radioButton1 = new JRadioButton("Java");

        frame.add(radioButton);
        radioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radioButton1.setSelected(false);
                label2.setText("Your favorite language is c++");
            }
        });

        frame.add(radioButton1);
        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radioButton.setSelected(false);
                label2.setText("Your favorite language is java");
            }
        });

        JButton button = new JButton("Reset");
        frame.add(button);
        button.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField1.setText("");
                radioButton.setSelected(false);
                radioButton1.setSelected(false);
            }
        });

        JButton button2 = new JButton("Login");
        frame.add(button2);
        button2.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = textField.getText();
                System.out.println("Username : " + user);
                String pass = textField1.getText();
                System.out.println("Password : " + pass);
            }
        });

        frame.add(label2);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frame1();
            }
        });
    }
}
