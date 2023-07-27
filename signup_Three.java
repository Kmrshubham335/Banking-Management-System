import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup_Three extends JFrame {
        JTextField panJTextField,addJTextField;
        JRadioButton r1,r2,r3,r4;
        JComboBox cate,in,ed,ree,oc,qualify;
        String formno;
    signup_Three(){
        this.formno=formno;
         setLayout(null);
        setVisible(true);
        setTitle("Page 3");
        setSize(850,800);
        setLocation(300,10);

        JLabel adDetailsJLabel = new JLabel("Page3- Account Details ");
        adDetailsJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        adDetailsJLabel.setBounds(290,80,400,30);
        add(adDetailsJLabel);

        JLabel typeJLabel = new JLabel("Account Type");
        typeJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        typeJLabel.setBounds(100,140,170,30);
        add(typeJLabel);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Arial", Font.PLAIN, 20));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 200, 30);
        r1.setActionCommand("Saving Account");
        add(r1);

        r2 = new JRadioButton(" Fixed Deposit");
        r2.setFont(new Font("Arial", Font.PLAIN, 20));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180 , 160, 30);
        r2.setActionCommand("Fixed Deposit");
        add(r2);

        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Arial", Font.PLAIN, 20));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 200, 30);
        r3.setActionCommand("Current Account");
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Arial", Font.PLAIN, 20));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 290, 30);
        r4.setActionCommand("Recurring Deposit Account");
        add(r4);

        ButtonGroup type= new ButtonGroup();
        type.add(r1);
        type.add(r2);
        type.add(r3);
        type.add(r4);
    }
    public static void main(String[] args) {
        new signup_Three();
    }
    }