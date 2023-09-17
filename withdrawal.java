import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
public class withdrawal extends JFrame implements ActionListener{
    JLabel textJLabel;
    JTextField amountTextField;
    JButton withdrawal,backButton;
    String pin;
    withdrawal(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        textJLabel=new JLabel("Enter the amount for withdrawal");
        textJLabel.setForeground(Color.WHITE);
        textJLabel.setFont(new Font("System", Font.BOLD,16));
        textJLabel.setBounds(210, 230, 700,20);
        image.add(textJLabel);

        amountTextField=new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD,16));
        amountTextField.setBounds(220,290 , 200,20);
        image.add(amountTextField);

        withdrawal =new JButton("Withdraw");
        withdrawal.setBounds(200, 390, 100, 20);
        withdrawal.setBackground(Color.BLACK);
        withdrawal.setForeground(Color.WHITE);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        backButton =new JButton("Back");
        backButton.setBounds(400, 390, 100, 20);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        image.add(backButton);



        setSize(900, 1000);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
       new  withdrawal("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==withdrawal){
            String number=amountTextField.getText();
           Date  date =new Date();
           if(number.equals(" ")){
            JOptionPane.showMessageDialog(null, "Enter the amount you want to withdrawal");
           }
           else{
            try {
                Conn con =new Conn();
                String query = "insert into deposit values('"+pin+"','"+date+"','withdrawal','"+number+"') ";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+number+"Withdrawal Successfully");
                setVisible(false);
                new Transaction(query).setVisible(true);

            } catch (SQLException se) {
                System.out.println(se);
            }
                      }
                    }
        else if(e.getSource()==backButton){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }

    }
}

