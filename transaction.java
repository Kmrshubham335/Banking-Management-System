import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class transaction extends JFrame{
    transaction(){
        // ImageIcon ii=new ImageIcon(ClassLoader.getSystemClassLoader());

        setSize(900,900);
        setLocation(200,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new transaction();
    }
}
