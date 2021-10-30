import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckOut extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;


    CheckOut(){

        JLabel l1 = new JLabel("Check Out");
        l1.setBounds(100,20,100,30);
        l1.setFont(new Font("Taboma", Font.PLAIN,18));
        add(l1);


        //Customer Id
        JLabel l2 = new JLabel("Customer Id");
        l2.setBounds(30,80,100,30);
        add(l2);

        c1 = new Choice();
        try{
            Conexion c = new Conexion();
            ResultSet rSet = c.s.executeQuery("select * from customer");
            while(rSet.next()){
                c1.add(rSet.getString("number"));
            }
        }catch (Exception ex){
            ex.getStackTrace();
        }
        c1.setBounds(150,80,150,30);
        add(c1);


        //Room number
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(150,130,150,30);
        add(t1);


        b1 = new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,200,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(170,200,120,30);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(310,80,20,20);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(350,0,400,250);
        add(l4);


        setLayout(null);
        setBounds(50,200,800,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){

            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number = '"+id+"'";
            String str2 = "update room set available = 'Available' where room_number = '"+room+"'";


            try {
                Conexion c = new Conexion();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Checkout done");

                //new Reception().setVisible(true);
                //this.setVisible(false);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }else if(e.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);

        }else if(e.getSource() == b3){
            String id = c1.getSelectedItem();


            try {
                Conexion c = new Conexion();
                ResultSet rSet = c.s.executeQuery("select * from customer where number = '"+id+"'");
                while(rSet.next()){
                    t1.setText(rSet.getString("room"));

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }


}
