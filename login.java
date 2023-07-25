import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class login extends JFrame implements ActionListener {
  JButton login,clear ,sign;
  JTextField CardNo;
  JPasswordField pinNo;
    login() {
        setLayout(null);          // Set custom layout manager
        setSize(500, 500);  // Set the size of the JFrame
        setVisible(true);               // Make the JFrame visible
        setLocation(400, 200);         // Set the location of the JFrame
        setTitle("Automatic Teller Machine");   // Set the title of the JFrame

        // Load the image
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("icons/bankicon.jpg"));
        Image i1 = ii.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(i1);

        // Create and configure the JLabel with the image
        JLabel jl1 = new JLabel(icon);
        jl1.setBounds(70, 100, 100, 100);   // Set the   position and size of the JLabel
        add(jl1); // Add the JLabel to the JFrame

        getContentPane().setBackground(Color.WHITE); // Set the background color of the JFrame

        JLabel text =new JLabel("Welcome to ATM");
        text.setFont(new Font("SansSerif",Font.BOLD,40));
        text.setBounds(500, 100, 400, 40);
        add(text);

        JLabel cardno =new JLabel("Enter the card number:");
        cardno.setFont(new Font("SansSerif",Font.PLAIN,38));
        cardno.setBounds(200, 200, 400, 40);
        add(cardno);

         CardNo=new JTextField();
        CardNo.setBounds(600, 202, 250, 40);
        CardNo.setFont(new Font("Arial",Font.BOLD,15));
        add(CardNo);

        JLabel pin =new JLabel("Enter the Pin:");
        pin.setFont(new Font("SansSerif",Font.PLAIN,38));
        pin.setBounds(200, 300, 350, 40);
        add(pin);

        pinNo=new JPasswordField();
        pinNo.setBounds(440,301,250,40);
        pinNo.setFont(new Font("Arial",Font.BOLD,15));
        add(pinNo);

         login=new JButton("SIGN IN");
        login.setBounds(300,355,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

         clear=new JButton("CLEAR");
        clear.setBounds(500,355,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

         sign=new JButton("Sign up");
        sign.setBounds(320,394,230,30);
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.WHITE);
        sign.addActionListener(this);
        add(sign);
    }

        @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==login){
        // String cardNumber=CardNo.getText();
        // String pin =new String(pinNo.getPassword());
      }
      else if(ae.getSource()==sign)
      {
        setVisible(false);
        new signup_One().setVisible(true);
      }
      else if(ae.getSource()==clear){
        CardNo.setText("");
        pinNo.setText("");
      }

    }
    public static void main(String[] args) {
      new login();
    }
    }


