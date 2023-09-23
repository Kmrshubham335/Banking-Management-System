
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
class miniState extends JFrame implements ActionListener{
    JLabel text;
        JButton backButton;
        String pinnumber;
    miniState(String pinnumber)
    {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);


        text=new JLabel("Indian Bank");
        text.setBounds(250,250,200,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD, 25));
        image.add(text);

        JLabel card=new JLabel();
        card.setBounds(150,300,300,20);
         card.setForeground(Color.WHITE);
        image.add(card);
        
        
        JLabel mini=new JLabel();
        mini.setBounds(150,359,400,30);
         mini.setForeground(Color.WHITE);
        image.add(mini);
        // mini.setOpaque(true);
        try {
            Conn con=new Conn();
            ResultSet rs=con.s.executeQuery("Select * from login where pinnumber='"+pinnumber+"'");
            while(rs.next()){
                card.setText("CardNumber:"+rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX" +rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
          System.out.println(e); 
        }

        try {
            Conn con=new Conn();
            ResultSet rs=con.s.executeQuery("Select * from deposit where pin='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }
            
        } 
        catch (Exception e) {
            System.out.println(e);
        }


        setTitle("Mini Statement");
        setSize(900, 1000);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public static void main(String[] args) {
        new miniState("");
    }
}
