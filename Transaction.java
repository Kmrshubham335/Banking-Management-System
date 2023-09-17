import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JLabel text;
    JButton depositButton, withdrawalButton, FastCashbutton, ministatement, jpin, jexitButton, balanceButton;
    String pin;
    Transaction(String pin) {
        this.pin=pin;
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        text = new JLabel("Please select your Transaction");
        text.setBounds(210, 230, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(140, 325, 90, 30);
        depositButton.addActionListener(this);
        depositButton.setBackground(Color.BLACK);
        depositButton.setForeground(Color.white);
        image.add(depositButton);

        withdrawalButton = new JButton("Withdrawal");
        withdrawalButton.setBounds(400, 325, 100, 30);
        withdrawalButton.addActionListener(this);
        withdrawalButton.setBackground(Color.BLACK);
        withdrawalButton.setForeground(Color.white);
        image.add(withdrawalButton);

        FastCashbutton = new JButton("FastCash");
        FastCashbutton.setBounds(140, 360, 90, 30);
        FastCashbutton.addActionListener(this); // Moved this line after button creation
        FastCashbutton.setBackground(Color.BLACK);
        FastCashbutton.setForeground(Color.white);
        image.add(FastCashbutton);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(380, 360, 130, 30);
        ministatement.addActionListener(this); // Moved this line after button creation
        ministatement.setBackground(Color.BLACK);
        ministatement.setForeground(Color.WHITE);
        image.add(ministatement);

        jpin = new JButton("Pin Change");
        jpin.setBounds(140, 400, 110, 30);
        jpin.addActionListener(this);
        jpin.setBackground(Color.BLACK);
        jpin.setForeground(Color.WHITE);
        image.add(jpin);

        balanceButton = new JButton("Balance Enquire");
        balanceButton.setBounds(380, 390, 130, 30);
        balanceButton.addActionListener(this);
        balanceButton.setBackground(Color.BLACK);
        balanceButton.setForeground(Color.white);
        image.add(balanceButton);

        jexitButton = new JButton("Exit");
        jexitButton.setBounds(400, 420, 100, 30);
        jexitButton.addActionListener(this);
        jexitButton.setBackground(Color.BLACK);
        jexitButton.setForeground(Color.WHITE);
        image.add(jexitButton);

        setSize(900, 1000);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Transaction("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jexitButton){
            System.exit(0);
        }
        else if(e.getSource()==depositButton){
            setVisible(false);
            new deposit(pin).setVisible(true);
        }
        else if(e.getSource()==withdrawalButton){
            setVisible(false);
            new withdrawal(pin).setVisible(true);
        }
        else if(e.getSource()==FastCashbutton){
            setVisible(false);
            new fastcash(pin).setVisible(true);
        }
    }
}
