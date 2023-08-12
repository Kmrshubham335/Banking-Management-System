import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class trans extends JFrame {
    public trans() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon originalIcon = new ImageIcon(getClass().getResource(("icons/atm.jpg")));
        Image scaledImage = originalIcon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 900, 700);
        add(imageLabel);
        

        setSize(new Dimension(900, 700));
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new trans();
        });
    }
}