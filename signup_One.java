import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup_One extends JFrame implements ActionListener {
    long ran;
    JLabel formno;
    JTextField nameTextField, FatherTextField, mailTextField, pinTextField, addressTextField, cTextField, stateTextField;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male, female, single, married;

    signup_One() {
        setLayout(null);
        getContentPane().setBackground(Color.lightGray);
        setSize(850, 800);
        setVisible(true);
        setLocation(300, 10);

        Random random = new Random();
        ran = Math.abs((random.nextLong() % 9000L) + 1000L);

        // Application number label
        JLabel formno = new JLabel("Application Number " + ran);
        formno.setFont(new Font("Arial Black", Font.BOLD, 30));
        formno.setBounds(499, 20, 600, 40);
        add(formno);

        // Personal details label
        JLabel personalDetails = new JLabel("Page1 Personal Details");
        personalDetails.setFont(new Font("Arial Black", Font.BOLD, 28));
        personalDetails.setBounds(499, 70, 600, 40);
        add(personalDetails);

        // Name label
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Arial Black", Font.BOLD, 28));
        name.setBounds(160, 150, 300, 60);
        add(name);

        // Name text field
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 25));
        nameTextField.setBounds(280, 160, 210, 45);
        add(nameTextField);

        // Father's name label
        JLabel fname = new JLabel("Father Name:");
        fname.setFont(new Font("Arial Black", Font.BOLD, 28));
        fname.setBounds(160, 200, 250, 60);
        add(fname);

        // Father's name text field
        FatherTextField = new JTextField();
        FatherTextField.setFont(new Font("Arial", Font.BOLD, 25));
        FatherTextField.setBounds(400, 210, 210, 40);
        add(FatherTextField);

        // Date of Birth label
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Arial Black", Font.BOLD, 28));
        dob.setBounds(160, 250, 250, 60);
        add(dob);

        // Date chooser for Date of Birth
        dateChooser = new JDateChooser();
        dateChooser.setBounds(400, 265, 190, 30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

       // Gender radio buttons
       JLabel gender = new JLabel("Gender:");
       gender.setFont(new Font("Arial Black", Font.BOLD, 28));
       gender.setBounds(160, 300, 250, 60);
       add(gender);

       male = new JRadioButton("Male");
       male.setFont(new Font("Arial", Font.PLAIN, 20));
       male.setBackground(Color.white);
       male.setBounds(400, 310, 100, 30);
       male.setActionCommand("Male");
       add(male);

       female = new JRadioButton("Female");
       female.setFont(new Font("Arial", Font.PLAIN, 20));
       female.setBackground(Color.WHITE);
       female.setBounds(570, 310, 100, 30);
       female.setActionCommand("Female");
       add(female);

       ButtonGroup genderGroup = new ButtonGroup();
       genderGroup.add(male);
       genderGroup.add(female);

        // Email label
        JLabel mail = new JLabel("E-Mail Address:");
        mail.setFont(new Font("Arial Black", Font.BOLD, 28));
        mail.setBounds(160, 350, 250, 60);
        add(mail);

        // Email text field
        mailTextField = new JTextField();
        mailTextField.setFont(new Font("Arial", Font.BOLD, 25));
        mailTextField.setBounds(430, 355, 210, 40);
        add(mailTextField);

        // Marital status radio buttons
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Arial Black", Font.BOLD, 28));
        marital.setBounds(160, 400, 250, 60);
        add(marital);

        single = new JRadioButton("Single");
        single.setFont(new Font("Arial", Font.PLAIN, 20));
        single.setBackground(Color.WHITE);
        single.setBounds(420, 420, 100, 30);
        single.setActionCommand("Single");
        add(single);

        married = new JRadioButton("Married");
        married.setFont(new Font("Arial", Font.PLAIN, 20));
        married.setBackground(Color.WHITE);
        married.setBounds(550, 420, 100, 30);
        married.setActionCommand("Married");
        add(married);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(single);
        maritalGroup.add(married);

        // Address label
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Arial Black", Font.BOLD, 28));
        address.setBounds(160, 450, 250, 60);
        add(address);

        // Address text field
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 25));
        addressTextField.setBounds(320, 460, 210, 40);
        add(addressTextField);

        // City label
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Arial Black", Font.BOLD, 28));
        city.setBounds(160, 500, 250, 60);
        add(city);

        // City text field
        cTextField = new JTextField();
        cTextField.setFont(new Font("Arial", Font.BOLD, 25));
        cTextField.setBounds(320, 510, 210, 40);
        add(cTextField);

        // State label
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Arial Black", Font.BOLD, 28));
        state.setBounds(160, 550, 250, 60);
        add(state);

        // State text field
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial", Font.BOLD, 25));
        stateTextField.setBounds(320, 560, 210, 40);
        add(stateTextField);

        // Pin Code label
        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Arial Black", Font.BOLD, 28));
        pin.setBounds(160, 600, 250, 60);
        add(pin);

        // Pin Code text field
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Arial", Font.BOLD, 25));
        pinTextField.setBounds(320, 610, 210, 40);
        add(pinTextField);

        // Next button
        JButton next = new JButton("Next");
        next.setForeground(Color.black);
        next.setBackground(Color.decode("#FFB74D")); // For button color change
        next.setFont(new Font("Raleway", Font.PLAIN, 20));
        next.setBounds(900, 660, 80, 30);
        next.addActionListener(this); // Add action listener to the next button
        add(next);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + ran; // Convert long to String
        String name = nameTextField.getText();
        String fname = FatherTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = male.getActionCommand(); // Retrieve the selected action command for gender
        } else if (female.isSelected()) {
            gender = female.getActionCommand(); // Retrieve the selected action command for gender
        }
        String mail = mailTextField.getText();
        String marital = null;
        if (single.isSelected()) {
            marital = single.getActionCommand(); // Retrieve the selected action command for marital status
        } else if (married.isSelected()) {
            marital = married.getActionCommand(); // Retrieve the selected action command for marital status
        }
        String address = addressTextField.getText();
        String city = cTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        try {
            //validating  each JLabel

            if (name.equals("")) {
                JOptionPane.showMessageDialog(signup_One.this, "Please Enter Name");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(signup_One.this, "Please enter father's name ");
            } else if (((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().equals("")) {
                JOptionPane.showMessageDialog(signup_One.this, "Enter Date of Birth Please!");
            } else if (gender == null) {
                JOptionPane.showMessageDialog(signup_One.this, "Select Gender please.");
            } else if (mail.equals("")) {
                JOptionPane.showMessageDialog(signup_One.this, "Please provide your email id.");
            } else if (!isValidEmail(mail)) {
                JOptionPane.showMessageDialog(signup_One.this, "Invalid email address. Please enter a valid email id.");
            } else if (marital == null) {
                JOptionPane.showMessageDialog(signup_One.this, "Choose Marital Status.");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(signup_One.this, "Provide Address Details.");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(signup_One.this, "Provide City details.");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(signup_One.this, "Provide State details.");
            } else if (pin == null || !(pin.matches("\\d+"))) {
                JOptionPane.showMessageDialog(signup_One.this, "Invalid Pincode format!");
            } else {
                // establish connection 
                
                Conn con = new Conn();
                String query = "INSERT INTO signup VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + mail + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
                con.s.executeUpdate(query);
                System.out.println("Data inserted successfully!");
                setVisible(false);
                new signup_Two(formno).setVisible(true);
            }
        } catch (SQLException se) {
            System.out.println("Error: "+ se);
        }
    }

    // Method to validate email address using regular expression
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        new signup_One();
    }
}

