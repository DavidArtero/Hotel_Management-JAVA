import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox<String> c1;
    Choice c2;
    JRadioButton r1,r2;

    AddCustomer(){
         JLabel l1 = new JLabel("NEW CUSTOMER FORM");
         l1.setBounds(100,20,300,30);
         l1.setFont(new Font("Tahoma", Font.BOLD,20));
         add(l1);

         JLabel l2 = new JLabel("ID");
         l2.setBounds(35,80,100,20);
         add(l2);

         c1 = new JComboBox<>(new String[]{"Passport",  "Driving Licence", "DNI"});
         c1.setBounds(200,80,150,25);
         add(c1);

        //Number
        JLabel l3 = new JLabel("Number");
        l3.setBounds(35,120,100,20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);

        //Name
        JLabel l4 = new JLabel("Name");
        l4.setBounds(35,160,100,20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);

        //Gender
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(35,200,100,20);
        add(l5);

        r1 = new JRadioButton("Male");
        r1.setBounds(200,200,60,25);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(270,200,80,25);
        r2.setBackground(Color.WHITE);
        add(r2);


        //Country
        JLabel l6 = new JLabel("Country");
        l6.setBounds(35,240,100,20);
        add(l6);

        t3 = new JTextField();
        t3.setBounds(200,240,150,25);
        add(t3);

        //Allocated Room Nº
        JLabel l7 = new JLabel("Allocated Room Number");
        l7.setBounds(35,280,150,20);
        add(l7);

        c2 = new Choice();

        try{
            Conexion c = new Conexion();
            String str = "select * from room";
            ResultSet rSet = c.s.executeQuery(str);
            while(rSet.next()){
                c2.add(rSet.getString("room_number"));
            }

        }catch (Exception e){}
        c2.setBounds(200,280,150,25);
        add(c2);

        //Check In
        JLabel l8 = new JLabel("Check In");
        l8.setBounds(35,320,100,20);
        add(l8);

        t4 = new JTextField();
        t4.setBounds(200,320,150,25);
        add(t4);

        //Deposit
        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(35,360,100,20);
        add(l9);

        t5 = new JTextField();
        t5.setBounds(200,360,150,25);
        add(t5);


        //Buttons
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(55,410,120,25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(210,410,120,25);
        b1.addActionListener(this);
        add(b2);




        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500,200,900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = (String) c1.getSelectedItem();
        String number = t1.getText();
        String name = t2.getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        String country = t3.getText();
        String room = c2.getSelectedItem();
        String status = t4.getText();
        String deposit = t5.getText();
    }

    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }


}
