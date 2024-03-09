package Bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawl, ministatement, pinchange, fastcash, Balanceenquiry, exit;

    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);

        add(image);

        JLabel text = new JLabel("Please Select Your Transaction:");
        text.setBounds(190, 300, 700, 40);

        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Card withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("fastcash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        Balanceenquiry = new JButton("Balance Enquiry");
        Balanceenquiry.setBounds(355, 450, 150, 30);
        Balanceenquiry.addActionListener(this);
        image.add(Balanceenquiry);

        pinchange = new JButton("Exit");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        /*
         * * Balanceenquiry = new JButton("Balance Enquiry");
         * Balanceenquiry.setBounds(355, 485, 150, 30);
         * Balanceenquiry.addActionListener(this);
         * image.add(Balanceenquiry);
         * 
         * exit = new JButton("Exit");
         * exit.setBounds(355, 520, 150, 30);
         * exit.addActionListener(this);
         * image.add(exit);
         */

        setSize(900, 900);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);

        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new fastcash(pinnumber).setVisible(true);
        } else if (ae.getSource() == Balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
