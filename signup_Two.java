import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup_Two extends JFrame implements ActionListener {
        JTextField panJTextField,addJTextField;
        JRadioButton syes,sno,eyes,eno;
        JComboBox cate,in,ed,ree,oc,qualify;
        String formno;
    signup_Two(String formno){
        this.formno=formno;

        JLabel addDetailsJLabel = new JLabel("Page2 - Additional Details ");
        addDetailsJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        addDetailsJLabel.setBounds(290,80,400,30);
        add(addDetailsJLabel);

        JLabel religionsJLabel = new JLabel("Religion:");
        religionsJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        religionsJLabel.setBounds(100,140,100,30);
        add(religionsJLabel);

        String[] valreligion={"Hindu","Muslim","Sikh","Christian","Other"};
        ree= new JComboBox<>(valreligion);
        ree.setBounds(300,140,400,30);
        ree.setBackground(Color.WHITE);
        add(ree);
        ree.setSelectedItem(null);
       

        JLabel categoriesJLabel = new JLabel("Categories:");
        categoriesJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        categoriesJLabel.setBounds(100,190,200,30);
        add(categoriesJLabel);

        String[] valca={"General","SC","ST","OBC","Other"};
        cate= new JComboBox<>(valca);
        cate.setBounds(300,190,400,30);
        cate.setBackground(Color.WHITE);
        add(cate);
        cate.setSelectedItem(null);
       
        JLabel incomeJLabel = new JLabel("Income:");
        incomeJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        incomeJLabel.setBounds(100,240,200,30);
        add(incomeJLabel);

       String[] valincome={"Null","<1,25,000","<5,00,000","<30,00,000","upto90,00,000"};
        in= new JComboBox<>(valincome);
        in.setBounds(300,240,400,30);
        in.setBackground(Color.WHITE);
        add(in);
        in.setSelectedItem(null);

        JLabel educationJLabel = new JLabel("Educational:");
        educationJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        educationJLabel.setBounds(100,290,200,30);
        add(educationJLabel);

        String[] valedu={"Post-Graduation","Graduation","Non-Graduate","Doctorate"};
        ed= new JComboBox<>(valedu);
        ed.setBounds(300,290,400,30);
        ed.setBackground(Color.WHITE);
        add(ed);
        ed.setSelectedItem(null);

        JLabel qualificationJLabel = new JLabel("Qualification:");
        qualificationJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        qualificationJLabel.setBounds(100,340,200,30);
        add(qualificationJLabel);

        String[] qua={"BCA","MCA","B.tech","BA","others"};
        qualify= new JComboBox<>(qua);
        qualify.setBounds(300,340,400,30);
        qualify.setBackground(Color.WHITE);
        add(qualify);
        qualify.setSelectedItem(null);

        JLabel occupationJLabel = new JLabel("Occupation:");
        occupationJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        occupationJLabel.setBounds(100,390,200,30);
        add(occupationJLabel);

        String[] occ={"salaried","Self-Employed","Student","Business"};
        oc= new JComboBox<>(occ);
        oc.setBounds(300,390,400,30);
        oc.setBackground(Color.WHITE);
        add(oc);
        oc.setSelectedItem(null);


        JLabel panJLabel = new JLabel("Pan Number:");
        panJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        panJLabel.setBounds(100,440,200,30);
        add(panJLabel);

        panJTextField =new JTextField();
        panJTextField.setFont(new Font("Raleway",Font.PLAIN,22));
        panJTextField.setBounds(300,440,300,30);
        add(panJTextField);
        

        JLabel aadharJLabel = new JLabel("AadharNumber:");
        aadharJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        aadharJLabel.setBounds(100,490,200,30);
        add(aadharJLabel);

        addJTextField =new JTextField();
        addJTextField.setFont(new Font("Raleway",Font.PLAIN,25));
        addJTextField.setBounds(290,490,350,30);
        add(addJTextField);

       JLabel seniorJLabel = new JLabel("SeniorCitizen:");
        seniorJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        seniorJLabel.setBounds(100,540,200,30);
        add(seniorJLabel);

        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Arial", Font.PLAIN, 20));
        syes.setBackground(Color.WHITE);
        syes.setBounds(420, 540, 100, 30);
        syes.setActionCommand("Yes");
        add(syes);

        sno = new JRadioButton("No");
        sno.setFont(new Font("Arial", Font.PLAIN, 20));
        sno.setBackground(Color.white);
        sno.setBounds(550, 540, 100, 30);
        sno.setActionCommand("No");
        add(sno);

        ButtonGroup SGroup = new ButtonGroup();
        SGroup.add(syes);
        SGroup.add(sno);
        sno.setOpaque(false);
        syes.setOpaque(false);

      JLabel exitJLabel = new JLabel("Existing Account :");
        exitJLabel.setFont(new Font("Raleway",Font.BOLD ,22));
        exitJLabel.setBounds(100,590,200,30);
        add(exitJLabel);

        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Arial", Font.PLAIN, 20));
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(420,590, 100, 30);
        eyes.setActionCommand("Yes");
        add(eyes);

        eno = new JRadioButton("No");
        eno.setFont(new Font("Arial", Font.PLAIN, 20));
        eno.setBackground(Color.white);
        eno.setBounds(550, 590, 100, 30);
        eno.setActionCommand("No");
        add(eno);

        ButtonGroup SsGroup = new ButtonGroup();
        SsGroup.add(eyes);
        SsGroup.add(eno);
        eyes.setOpaque(false);
        eno.setOpaque(false);

        
        JButton next = new JButton("Next");
        next.setForeground(Color.black);
        next.setBackground(Color.decode("#FFB74D")); // For button color change
        next.setFont(new Font("Raleway", Font.PLAIN, 20));
        next.setBounds(900, 600, 80, 30);
        next.addActionListener(this); // Add action listener to the next button
        add(next);
          setLayout(null);
        setVisible(true);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
        setSize(1300,1300);
        setLocation(0,0);

    }

    public static void main(String[] args) throws Exception {
      String str="javax.swing.plaf.nimbus.NimbusLookAndFeel";
      UIManager.setLookAndFeel(str);
        new signup_Two("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religious = (String) ree.getSelectedItem();
        String cat=(String)cate.getSelectedItem();
        String income =(String)in.getSelectedItem();
        String education=(String) ed.getSelectedItem();
        String occupation=(String)oc.getSelectedItem();
        String qString=(String) qualify.getSelectedItem();
        String seniorCitizen=null;
        String exist=null;
        //validating

        if(ree.getSelectedItem()==null){
          JOptionPane.showMessageDialog(signup_Two.this,"Please select your Religion");
        }
        else if(cate.getSelectedItem()==null){
          JOptionPane.showMessageDialog(signup_Two.this,"Please Select Category");
        }
        else if(in.getSelectedItem()==null){
          JOptionPane.showMessageDialog(signup_Two.this," Please select your Income ");
        }
        else if(ed.getSelectedItem()==null){
          JOptionPane.showMessageDialog(signup_Two.this,"Please Select your Education");
        }
        else if(oc.getSelectedItem()==null){
          JOptionPane.showMessageDialog(signup_Two.this,"Please Select Your Occupation");
        }
        else if(qualify.getSelectedItem()==null){
          JOptionPane.showMessageDialog(signup_Two.this,"Please Select Your Qualification");
        }
        else{
          System.out.println("No selection is made");
        }
        if(syes.isSelected()){
            seniorCitizen="yes";
                }  
                else{
                    seniorCitizen ="no";}
          if(eyes.isSelected()){
            exist="yes";
          }
          else{
            exist="no";}

            String pan=panJTextField.getText();
            String aadharString=addJTextField.getText();
            if (isValidPan(pan) && isValidAadhar(aadharString)) 
            {
              JOptionPane.showMessageDialog(signup_Two.this,"PAN and Aadhar card numbers are valid. Authentication success!");
            }
            else{
              JOptionPane.showMessageDialog(signup_Two.this,"Invalid PAN or Aadhar card number. Authentication failed!");

            }
            try {
                Conn connection=new Conn();
    
                // Insert data into the table
                String insertDataQuery = "INSERT INTO signup_Two VALUES ('" +
                        formno + "', '" + religious + "', '" + cat + "', '" + income + "', '" + education + "', '" + qString + "', '" + occupation + "', '" + pan + "', '" + aadharString + "', '" + seniorCitizen + "', '" + exist + "')";
                  connection.s.executeUpdate(insertDataQuery);
                              JOptionPane.showMessageDialog(signup_Two.this, "Data Entered Successfully");

                              setVisible(false);
                              new signup_Three(formno).setVisible(true);
    
                // Display success message or perform any other actions as needed
                System.out.println("Data inserted successfully!");
            }catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
          }                  
        public static boolean isValidPan(String pan){
          String panregex ="[A-Z]{5}[0-9]{4}[A-Z]{1}";
          Pattern pattern = Pattern.compile(panregex);
          Matcher matcher = pattern.matcher(pan);
          return matcher.matches();
        }
          public static boolean isValidAadhar(String aadharString){
          String adharregex ="[A-Z]{5}[0-9]{4}[A-Z]{1}";
          Pattern pattern = Pattern.compile(adharregex);
          Matcher matcher = pattern.matcher(aadharString);
          return matcher.matches();
      }
    }