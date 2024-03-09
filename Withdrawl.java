package Bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton Withdraw, back;
    String pinnumber;
    connection c1;

    Withdrawl(String pinnumber) {
        c1 = new connection();

        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(175, 350, 320, 25);
        image.add(amount);

        Withdraw = new JButton(" Withdraw");
        Withdraw.setBounds(355, 485, 150, 30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Withdraw) {

            String number = amount.getText();

            if (number.equals(" ")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to  Withdraw");
            } else {
                try {
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = dateFormat.format(date);
                    String q1 = "INSERT INTO bank (pinnumber, date, type, amount) VALUES ('" + pinnumber + "', '"
                            + formattedDate + "', ' Withdraw', '" + number + "')";
                    PreparedStatement pstmt = c1.getConnection().prepareStatement(q1);

                    pstmt.executeUpdate();
                    // String q1 = "INSERT INTO Signup VALUES ('" + pinnumber + "', '', 'Deposit',
                    // '" + number + "')";

                    // c1.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Rs " + number + "  Withdraw Succussfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }

    }

    public static void main(String args[]) {
        new Deposit(" ");

    }

}
