package Bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JLabel text, cardnumber, pinnumber, query;

    JButton Login, Signup, Clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    connection c1;

    login() {
        c1 = new connection();
        setTitle("Automate Teller Machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        cardnumber = new JLabel("Card No:");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 28));
        cardnumber.setBounds(120, 150, 150, 30);
        add(cardnumber);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        pinnumber = new JLabel("PIN:");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 28));
        pinnumber.setBounds(120, 220, 250, 40);
        add(pinnumber);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        Login = new JButton("SIGN IN");
        Login.setBounds(300, 300, 100, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        add(Login);

        Clear = new JButton("CLEAR");
        Clear.setBounds(450, 300, 100, 30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.white);
        Clear.addActionListener(this);
        add(Clear);

        Signup = new JButton("SIGN UP");
        Signup.setBounds(300, 350, 230, 30);
        Signup.setBackground(Color.BLACK);
        Signup.setForeground(Color.white);
        Signup.addActionListener(this);
        add(Signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);

    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == Clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ac.getSource() == Login) {

            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "INSERT INTO login (cardnumber, pinnumber) VALUES (?, ?)";

            // String query = "select * from login where cardnumber = '" + cardnumber + "'
            // and pinnumber = '" + pinnumber
            // + "' ";

            // System.out.println("SQL Query: " + query);

            try (PreparedStatement pstmt = c1.getConnection().prepareStatement(query)) {

                pstmt.setString(1, cardnumber);
                pstmt.setString(2, pinnumber);
                // pstmt.executeUpdate();

                // ResultSet rs = c1.s.executeQuery(query);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
                pstmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace(); // Print detailed exception information
                JOptionPane.showMessageDialog(null, "Error executing SQL query");
            } catch (Exception e) {
                e.printStackTrace(); // Print detailed exception information
                JOptionPane.showMessageDialog(null, "An unexpected error occurred");
            }

        } else if (ac.getSource() == Signup) {
            setVisible(false);
            new Signup().setVisible(true);

        }

    }

    public static void main(String args[]) {
        new login();

    }
}
/*
 * catch (Exception e) {
 * 
 * System.out.println(e);
 * }*
 */