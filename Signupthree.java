package Bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signupthree extends JFrame implements ActionListener {

    connection con;

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton Submit, Cancel;
    String formno;

    Signupthree(String formno) {
        this.formno = formno;
        setLayout(null);
        con = new connection();

        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        l1.setBackground(new Color(222, 255, 228));
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        type.setBackground(new Color(222, 255, 228));
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBounds(100, 180, 150, 20);
        r1.setBackground(new Color(222, 255, 228));
        add(r1);

        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBounds(350, 180, 250, 20);
        r2.setBackground(new Color(222, 255, 228));
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBounds(100, 220, 250, 20);
        r3.setBackground(new Color(222, 255, 228));
        add(r3);

        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBounds(350, 220, 250, 20);
        r4.setBackground(new Color(222, 255, 228));
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        card.setBackground(new Color(222, 255, 228));
        add(card);

        JLabel number = new JLabel("xxxx-xxx-xxxx-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        number.setBackground(new Color(222, 255, 228));
        add(number);

        JLabel carddetail = new JLabel("Enter 16 Digit Card Number:");

        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 330, 300, 30);
        carddetail.setBackground(new Color(222, 255, 228));
        add(carddetail);

        JLabel pin = new JLabel("Pin ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        pin.setBackground(new Color(222, 255, 228));
        add(pin);

        JLabel pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        pnumber.setBackground(new Color(222, 255, 228));

        add(pnumber);

        JLabel pindetail = new JLabel("Enter 4 Digit Pin Number:");

        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 400, 300, 30);
        pindetail.setBackground(new Color(222, 255, 228));
        add(pindetail);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 450, 400, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        c1.setBackground(new Color(222, 255, 228));
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(100, 500, 200, 30);
        c2.setBackground(new Color(222, 255, 228));
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        c3.setBackground(new Color(222, 255, 228));
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        c4.setBackground(new Color(222, 255, 228));
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        c5.setBackground(new Color(222, 255, 228));
        add(c5);

        c6 = new JCheckBox("E Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        c6.setBackground(new Color(222, 255, 228));
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my Knowlegde");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        c7.setBackground(new Color(222, 255, 228));
        add(c7);

        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setFont(new Font("Raleway", Font.BOLD, 14));
        Submit.setBounds(250, 720, 100, 30);
        Submit.addActionListener(this);
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        Cancel.setBounds(420, 720, 100, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        setSize(850, 820);
        setLocation(150, 0);
        setVisible(true);
        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 900);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "saving account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposite Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recuring Deposite Account";
            }

            Random random = new Random();
            String cardnumber = " " + Math.abs((random.nextLong() % 90000000L) + 504093600000000L);
            String pinnumber = " " + Math.abs((random.nextLong() % 9000l) + 1000L);

            String facility = " ";
            if (c1.isSelected()) {
                facility = facility + "ATM Card";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (c3.isSelected()) {
                facility = facility + "EMAIL & SMS Alerts";
            } else if (c3.isSelected()) {
                facility = facility + "Cheque Book";
            } else if (c3.isSelected()) {
                facility = facility + "E-Statement";
            }

            try {

                if (accountType.equals(" ")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {

                    String q1 = "INSERT INTO Signupthree VALUES ('" + formno + "','" + accountType + "','" + cardnumber
                            + "','" + pinnumber + "','" + facility + "')";
                    String q2 = "INSERT INTO login (cardnumber, pinnumber) VALUES ('" + cardnumber + "','" + pinnumber
                            + "')";

                    // String q2 = "INSERT INTO login VALUES ('" + cardnumber + "','" + pinnumber +
                    // "')";

                    JOptionPane.showMessageDialog(null, "Card number:" + cardnumber + "\n Pin number:" + pinnumber);

                    con.s.executeUpdate(q1);
                    con.s.executeUpdate(q2);
                    setVisible(false);
                    // new Signupthree(formno).setVisible(true);
                    new Deposit(pinnumber).setVisible(false);

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == Cancel) {
            setVisible(false);
            new login().setVisible(true);

        }

    }

    public static void main(String args[]) {
        new Signupthree(" ");
    }
}
// + formno + "','" +