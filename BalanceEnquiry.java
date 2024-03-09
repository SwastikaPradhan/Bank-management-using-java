package Bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    connection c1;

    BalanceEnquiry(String pinnumber) {
        c1 = new connection();
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);

        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        int balance = 0;

        try {
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pinnumber  = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            ;
        } catch (SQLException e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400, 30);
        image.add(text);

        setSize(900, 900);
        setLocation(0, 300);
        setUndecorated(true);
        setVisible(true);
    }

    /*
     * String amount = "100"; // Replace with the actual amount you want to use
     * 
     * if (balance < Integer.parseInt(amount)) {
     * JOptionPane.showMessageDialog(null, "Insufficient Balance");
     * return;
     * }
     * 
     * Date date = new Date();
     * 
     * String query = "SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "'";
     * 
     * try (PreparedStatement pstmt = c1.getConnection().prepareStatement(query)) {
     * pstmt.setString(1, pinnumber);
     * pstmt.setDate(2, new java.sql.Date(date.getTime()));
     * pstmt.setString(3, amount);
     * 
     * int rowsAffected = pstmt.executeUpdate();
     * 
     * if (rowsAffected > 0) {
     * JOptionPane.showMessageDialog(null, "Rs " + amount +
     * " Debited Successfully");
     * 
     * setVisible(false);
     * new Transaction(pinnumber).setVisible(true);
     * } else {
     * JOptionPane.showMessageDialog(null, "Error: Unable to debit amount");
     * }
     * } catch (SQLException e) {
     * System.out.println(e);
     * }
     * 
     * } catch (Exception e) {
     * System.out.println(e);
     * }
     */

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
