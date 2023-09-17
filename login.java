import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame implements ActionListener {
    private JTextField cardNoTextField;
    private JPasswordField pinNoPasswordField;

    login() {
        setTitle("Automatic Teller Machine");
        setSize(1300, 1300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
        getContentPane().setBackground(Color.WHITE);


        ImageIcon gifIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login-2385.gif"));
        Image gifImage = gifIcon.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT);
        ImageIcon gifImageIcon = new ImageIcon(gifImage);
        JLabel gifLabel = new JLabel(gifImageIcon);
        gifLabel.setHorizontalAlignment(JLabel.CENTER);
        add(gifLabel);

        

        JLabel welcomeLabel = new JLabel("WELCOME TO ATM");
        welcomeLabel.setFont(new Font("Caslon", Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(welcomeLabel);

        JPanel cardNoPanel = new JPanel(new FlowLayout());
        JLabel cardNoLabel = new JLabel("Enter the card number:");
        cardNoTextField = new JTextField(20);
        cardNoPanel.add(cardNoLabel);
        cardNoPanel.add(cardNoTextField);
        add(cardNoPanel);

        JPanel pinNoPanel = new JPanel(new FlowLayout());
        JLabel pinNoLabel = new JLabel("Enter the PIN:");
        pinNoPasswordField = new JPasswordField(20);
        pinNoPanel.add(pinNoLabel);
        pinNoPanel.add(pinNoPasswordField);
        add(pinNoPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton signInButton = new JButton("SIGN IN");
        signInButton.addActionListener(this);
        JButton clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);
        JButton signUpButton = new JButton("Sign up");
        signUpButton.addActionListener(this);
        buttonPanel.add(signInButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(signUpButton);
        add(buttonPanel);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("SIGN IN")) {
            
            try {
                Conn con =new Conn();
            String cardNumber = cardNoTextField.getText();
            String pin = new String(pinNoPasswordField.getPassword());
            String q  = "select * from login where cardnumber = '"+cardNumber+"' and pinnumber = '"+pin+"'";
             ResultSet rs = con.s.executeQuery(q);
             if(rs.next()){
                setVisible(false);
                new Transaction(pin).setVisible(true);
             }
             else{
                JOptionPane.showMessageDialog(null,"Incorrect Card number or pin");
             }
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }
            // Add login validation and other logic here
         else if (ae.getActionCommand().equals("CLEAR")) {
            cardNoTextField.setText("");
            pinNoPasswordField.setText("");
        } else if (ae.getActionCommand().equals("Sign up")) {
            setVisible(false);
            new signup_One().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new login().setVisible(true));
    }
}

