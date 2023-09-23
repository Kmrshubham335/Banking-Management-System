import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
class BalanceEnq extends JFrame implements ActionListener{
    JLabel text;
        JButton backButton;
        String pinnumber;
    BalanceEnq(String pinnumber)
    {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        backButton =new JButton("BACK");
        backButton.setBounds(400, 420, 100, 30);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        // backButton.setBorderPainted(false); 
        image.add(backButton);
        int balance =0;
        try {
                Conn c=new Conn();
                               
                ResultSet rs =c.s.executeQuery("select * from deposit where pin='"+pinnumber+"'");

                while(rs.next()){
                    if(rs.getString("type").equals("amount")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                    else{
                        balance-=Integer.parseInt(rs.getString("amount")) ;
                    }
                }
            }
            catch(SQLException e){
                System.out.println(e);
            }

            text =new JLabel("YOUR CURRENT ACCOUNT BALANCE IS RS: " + balance);
            text.setBounds(170,200,150,30);
            text.setForeground(Color.WHITE);
            image.add(text);

        setSize(900, 1000);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);


}
public static void main(String[] args) {
    new BalanceEnq("");
}
@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==backButton){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
}
}