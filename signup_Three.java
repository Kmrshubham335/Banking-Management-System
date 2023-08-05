import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class signup_Three extends JFrame implements ActionListener {
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
        JRadioButton r1,r2,r3,r4;
        JButton submit,cancel;
        String formno;
    signup_Three(String formno){
        this.formno=formno;
        ImageIcon backgroundImageIcon = new ImageIcon("icons/texture-2119292.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        setContentPane(new JLabel(new ImageIcon(backgroundImage)));


        JLabel adDetailsJLabel = new JLabel("ACCOUNT DETAILS ");
        adDetailsJLabel.setFont(new Font("Raleway",Font.BOLD ,30));
        adDetailsJLabel.setBounds(500,80,400,30);
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
        r1.setOpaque(false);
        r2.setOpaque(false);
        r3.setOpaque(false);
        r4.setOpaque(false);
        
     JLabel cardJLabel = new JLabel("Card Number");
        cardJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        cardJLabel.setBounds(100,300,200,30);
        add(cardJLabel);

        JLabel num =new JLabel("XXXX-XXXX-XXXX-4124");
        num.setForeground(Color.RED);
        num.setFont(new Font ("Times New Roman" , Font.ITALIC,22));
        num.setBounds (330,300,300,30 );
        add(num);

         JLabel cardDetails =new JLabel("Your 16-digit card number");
        cardDetails.setForeground(Color.black);
        cardDetails.setFont(new Font ("Times New Roman" , Font.PLAIN,15));
        cardDetails.setBounds (100,320,300,30 );
        add(cardDetails);

         JLabel pinLabel =new JLabel("Pin");
        pinLabel.setForeground(Color.BLACK);
        pinLabel.setFont(new Font ("Raleway" , Font.BOLD,22));
        pinLabel.setBounds (100,370,100,30 );
        add(pinLabel);

         JLabel pinnoJLabel =new JLabel("XXXX");
        pinnoJLabel.setForeground(Color.RED);
        pinnoJLabel.setFont(new Font ("Times New Roman" , Font.ITALIC,22));
        pinnoJLabel.setBounds (330,370,300,30 );
        add(pinnoJLabel);
        
        JLabel pinDetails =new JLabel("Your 4-digit pin number");
        pinDetails.setForeground(Color.black);
        pinDetails.setFont(new Font ("Times New Roman" , Font.PLAIN,15));
        pinDetails.setBounds (100,390,300,30 );
        add(pinDetails);

         JLabel serviceJLabel =new JLabel("Services Required:");
        serviceJLabel.setForeground(Color.black);
        serviceJLabel.setFont(new Font ("Times New Roman" , Font.BOLD,20));
        serviceJLabel.setBounds (100,420,300,30 );
        add(serviceJLabel);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font ("Raleway",Font.BOLD,16));
        c1.setBounds(100,460,150,30);
        add(c1);
        c1.setOpaque(false);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.white);
        c2.setFont(new Font ("Raleway",Font.BOLD,16));
        c2.setBounds(350,460,190,30);
        add(c2);
        c2.setOpaque(false);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.white);
        c3.setFont(new Font ("Raleway",Font.BOLD,16));
        c3.setBounds(100,500,190,30);
        add(c3);
        c3.setOpaque(false);

        c4 = new JCheckBox("SMS AND E-MAIL ALERT");
        c4.setBackground(Color.white);
        c4.setFont(new Font ("Raleway",Font.BOLD,16));
        c4.setBounds(350,500,220,30);
        add(c4);
        c4.setOpaque(false);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.white);
        c5.setFont(new Font ("Raleway",Font.BOLD,16));
        c5.setBounds(100,550,150,30);
        add(c5);
        c5.setOpaque(false);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.white);
        c6.setFont(new Font ("Raleway",Font.BOLD,16));
        c6.setBounds(350,550,150,30);
        add(c6);
        c6.setOpaque(false);

        c7 = new JCheckBox("I hereby declare that all the information given above is true and correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font ("Raleway",Font.BOLD,16));
        c7.setBounds(100,600,800,30);
        add(c7);
        c7.setOpaque(false);

        submit = new JButton("Submit");
        submit.setForeground(Color.black);
        submit.setBackground(Color.decode("#FFB74D")); // For button color change
        submit.setFont(new Font("Raleway", Font.PLAIN, 20));
        submit.setBounds(400, 650, 100, 30);
        submit.addActionListener(this); // Add action listener to the next button
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.decode("#FFB74D")); // For button color change
        cancel.setFont(new Font("Raleway", Font.PLAIN, 20));
        cancel.setBounds(520, 650, 100, 30);
        cancel.addActionListener(this); // Add action listener to the cancel button
        add(cancel);
        setLayout(null);
        setTitle("Page 3");
        setSize(1300,1300);
        getContentPane().setBackground(Color.white);
        setLocation(0,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        new signup_Three("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
            String accounttype=null;
            if(r1.isSelected()){
                accounttype="Saving Account";
            }else if(r2.isSelected()){
                accounttype="Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                accounttype="Current Account";
            }
            else if(r4.isSelected()){
                accounttype="Recurring Deposits Account";
            }
            Random random=new Random();
            String cardnumber = "" +Math.abs((random.nextLong()% 90000000L)+50409636000000000L);
            String pinnumber= ""+Math.abs((random.nextLong()%9000L)+1000L);
            String facilityString="";
            if(c1.isSelected()){
                facilityString=facilityString+"ATM CARD";
            }
            else if(c2.isSelected()){
                facilityString+="Internet Banking";
            }
            else if(c3.isSelected()){
                facilityString+= "Mobile Banking";
            }
            else if(c4.isSelected()){
            facilityString+= "EMAIL AND SMS ALERT";
            }
            else if(c5.isSelected()){
                  facilityString+= "CHEQUE BOOK";
            }
            else if(c6.isSelected()){
                  facilityString+= "E-Statement";
            }

        //Insert Data into Database using SQL Query and JDBC Connection
            try {
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(signup_Three.this,"Account Type is Required");
                }
                else{
                    Conn conn= new Conn();
                    String insertDataQuery = "INSERT INTO signup_Three VALUES ('" +
                    formno + "', '" + accounttype + "', '" + cardnumber + "', '" + pinnumber + "', '" + facilityString+ "')";

                    String query2="INSERT INTO login VALUES('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

              conn.s.executeUpdate(insertDataQuery);
              conn.s.executeUpdate(query2);
              JOptionPane.showMessageDialog(signup_Three.this, "Data Entered Successfully \nCardNumber:"+cardnumber + "\nPinNumber:"+pinnumber);
              System.out.println("Printed");
              
                }
            } catch (Exception E) {
                JOptionPane.showMessageDialog(signup_Three.this, "Error occurred. Please Fill the details and try again.");
                System.out.println(E);
            }
        }
        else if(e.getSource()==cancel){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(
                signup_Three.this,
                "Are you sure you want to cancel?",
                "Cancel Confirmation",
                dialogButton
            );
            if (dialogResult == JOptionPane.YES_OPTION) {
                // User confirmed the cancel action
                dispose(); // Close the current window
            }
            else{
                JOptionPane.showMessageDialog(signup_Three.this, "Cancellation aborted.");
            }
        }
    }
    }
