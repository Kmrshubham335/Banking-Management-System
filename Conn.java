import java.sql.*;
public class Conn{
    Connection c;
    Statement s;
    public Conn() throws SQLException{
        try{
            c=DriverManager.getConnection("jdbc:mysql:///BankManagement","root","1999@Shubham");
            s=c.createStatement();
        }catch(SQLDataException e){
            System.out.println("Error in loading driver");
        }
    }
}
