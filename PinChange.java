import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class PinChange extends JFrame implements ActionListener{
    JLabel text,newpin,retext;
        JPasswordField jTextField1,jTextField2;
        JButton jb1,jb2;
        String pinnumber;
        JButton clearButton;
    PinChange(String Pinnumber)
    {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(210, 230, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

        newpin = new JLabel("NEW PIN");
        newpin.setBounds(150, 290,700 , 30);
        newpin.setFont(new Font("System", Font.BOLD, 16));
        newpin.setForeground(Color.WHITE);
        image.add(newpin);

        jTextField1 =new JPasswordField();
        jTextField1.setBounds(240,300,150,20);
        image.add(jTextField1);

        retext = new JLabel("RE-ENTER THE PIN");
        retext.setBounds(150,349,700,30);
        retext.setFont(new Font("System", Font.BOLD,16));
        retext.setForeground(Color.WHITE);
        image.add(retext);

       jTextField2=new JPasswordField();
        jTextField2.setBounds(320,355,100,20);
        image.add(jTextField2);

        jb1=new JButton("Change");
        jb1.setBounds(355,390,150,30);
        jb1.addActionListener(this);
        jb1.setBackground(Color.BLACK);
        jb1.setForeground(Color.WHITE);
        image.add(jb1);

        jb2=new JButton("Back");
        jb2.setBounds(150,390,150,30);
        jb2.addActionListener(this);
        jb2.setBackground(Color.BLACK);
        jb2.setForeground(Color.WHITE);
        image.add(jb2); 

        


        setSize(900, 1000);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
  
    }
    public static void main(String[] args) {
        new PinChange("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jb1){
        try {
            String npin=jTextField1.getText();
            String rpin=jTextField2.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Pin Does Not Matched");
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Pin");
                return;
            }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"ReEnter Pin Is Empty");
                    return;
                }
            jTextField1.setText("");
            jTextField2.setText("");

            clearButton.setToolTipText("Clears the password fields");
            Conn con=new Conn();
            String query1="update deposit set pin='"+rpin+"',where pin='"+pinnumber+"'";

             String query2="update signup_Three set npin='"+rpin+"',where pin='"+pinnumber+"'";

              String query3="update login set npin='"+rpin+"',where pin='"+pinnumber+"'";

              con.s.executeUpdate(query1);
              con.s.executeUpdate(query3);
              con.s.executeUpdate(query2);

              JOptionPane.showMessageDialog(null, "Pin Changed Successfully");

              setVisible(false);
              new Transaction(rpin).setVisible(true);



        } catch (Exception E) {
        System.out.println(e);
        }
    }else{
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

}
}