package Bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, ministatement, pinchange, fastcash, Balanceenquiry, exit;
    JLabel query;

    String pinnumber;
    connection c1;

    fastcash(String pinnumber) {
        c1 = new connection();
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);

        add(image);

        JLabel text = new JLabel("Select withdrawl Account: ");
        text.setBounds(190, 300, 700, 40);

        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 20000");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 50000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        Balanceenquiry = new JButton("Rs 10,000");
        Balanceenquiry.setBounds(355, 485, 150, 30);
        Balanceenquiry.addActionListener(this);
        image.add(Balanceenquiry);

        exit = new JButton("Back");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String amount = null;
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            amount = ((JButton) ae.getSource()).getText().substring(3);
        }

        try {
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pinnumber  = '" + pinnumber + "'");

            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if (ae.getSource() != exit && (balance < Integer.parseInt(amount))) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date = new Date();

            String pinnumber = "1234";
            // String query = "SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "'";
            String query = "INSERT INTO bank (pinnumber, date, amount) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = c1.getConnection().prepareStatement(query)) {
                pstmt.setString(1, pinnumber);
                pstmt.setDate(2, new java.sql.Date(date.getTime()));
                pstmt.setString(3, amount);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Unable to debit amount");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new fastcash("");
    }
}
