import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {
    JLabel text;
    JButton depositButton, withdrawalButton, FastCashbutton, ministatement, jpin, jexitButton, balanceButton;
    String pin;
    fastcash(String pin) {
        this.pin=pin;
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(210, 230, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

        depositButton = new JButton("RS100");
        depositButton.setBounds(140, 325, 90, 30);
        depositButton.addActionListener(this);
        depositButton.setBackground(Color.BLACK);
        depositButton.setForeground(Color.white);
        image.add(depositButton);

        withdrawalButton = new JButton("RS500");
        withdrawalButton.setBounds(400, 325, 100, 30);
        withdrawalButton.addActionListener(this);
        withdrawalButton.setBackground(Color.BLACK);
        withdrawalButton.setForeground(Color.white);
        image.add(withdrawalButton);

        FastCashbutton = new JButton("RS1000");
        FastCashbutton.setBounds(140, 360, 90, 30);
        FastCashbutton.addActionListener(this); // Moved this line after button creation
        FastCashbutton.setBackground(Color.BLACK);
        FastCashbutton.setForeground(Color.white);
        image.add(FastCashbutton);

        ministatement = new JButton("RS2000");
        ministatement.setBounds(380, 360, 130, 30);
        ministatement.addActionListener(this); // Moved this line after button creation
        ministatement.setBackground(Color.BLACK);
        ministatement.setForeground(Color.WHITE);
        image.add(ministatement);

        jpin = new JButton("RS5000");
        jpin.setBounds(140, 400, 110, 30);
        jpin.addActionListener(this);
        jpin.setBackground(Color.BLACK);
        jpin.setForeground(Color.WHITE);
        image.add(jpin);

        balanceButton = new JButton("RS10000");
        balanceButton.setBounds(380, 390, 130, 30);
        balanceButton.addActionListener(this);
        balanceButton.setBackground(Color.BLACK);
        balanceButton.setForeground(Color.white);
        image.add(balanceButton);

        jexitButton = new JButton("Back");
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
        new fastcash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jexitButton){
            setVisible(false);
            new Transaction(pin).setVisible(true);

        }
        else{
            String amount1 =((JButton)e.getSource()).getText().substring(2); //putting text from the button
            try {
                Conn c=new Conn();

                ResultSet rs = c.s.executeQuery("SELECT * FROM deposit WHERE pin='" + pin + "'");
                int balance =0;
            
                while(rs.next()){
                    String prevamt;
                    prevamt = rs.getString("amount");
                    int Prevamt = Integer.parseInt(prevamt);
                    
                    if(rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(amount1);
                    String update = ""+balance+Prevamt;
                    String query = "update deposit set amount = '"+update+"'";
                    c.s.executeUpdate(query);
                }
                    else{
                        String update =""+(Prevamt-balance);
                        String query = "update deposit set amount = '"+update+"'";
                        c.s.executeUpdate(query);
                        
                    }
                }
                if(e.getSource()!=jexitButton && balance<Integer.parseInt(amount1)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String transactionDate = sdf.format(new Date());
                String query = "insert into deposit values('" + pin + "','" + transactionDate + "','Withdrawal','" + amount1 + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS"+ amount1+ "Withdrawn Successfully");
            } 
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}