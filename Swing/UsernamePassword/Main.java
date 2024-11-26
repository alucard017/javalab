package javalab.Swing.UsernamePassword;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 120);
        frame.setLayout(new GridLayout(2, 3, 5, 10));

        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();

        JButton loginButton = new JButton("Login");
        JButton resetButton = new JButton("Reset");

        frame.add(new JLabel("Username:"));
        frame.add(usernameField);

        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        frame.setVisible(true);
    }
}
// import javax.swing.*;
// import java.awt.*;

// public class Main {
// public static void main(String[] args) {
// JFrame frame = new JFrame("FlowLayout Example");
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// frame.setSize(300, 100); // Adjusted frame size
//
// frame.setLayout(new FlowLayout());
//
// JButton leftButton = new JButton("Left");
// JButton rightButton = new JButton("Right");
// JLabel label = new JLabel("Click a Button");
//
// frame.add(leftButton);
// frame.add(rightButton);
// frame.add(label);
//
// frame.setVisible(true);
// }
// }
