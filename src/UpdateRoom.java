import javax.management.relation.RelationSupport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;

    UpdateRoom(){

        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        l1.setBounds(20,30,200,30);
        add(l1);

        //Id
        JLabel l2 = new JLabel("Guest ID");
        l2.setBounds(30,80,120,20);
        add(l2);

        c1 = new Choice();

        try{
            Conexion c = new Conexion();
            ResultSet rSet = c.s.executeQuery("select * from customer");

            while(rSet.next()){
                c1.add(rSet.getString("number"));
            }
        }catch (Exception exc){
            System.out.println(exc);
        }

        c1.setBounds(200,80,150,25);
        add(c1);


        //Room number
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,120,20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);

        //Availability
        JLabel l4 = new JLabel("Availability");
        l4.setBounds(30,180,120,20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);


        //Clean Status
        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(30,230,120,20);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);

        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130,300,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,350,120,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(220,350,120,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(400,10,500,400);
        add(l6);

        setLayout(null);
        setBounds(500,200,950,450);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            String room = null;
            String s1 = c1.getSelectedItem();

            Conexion c = new Conexion();
            try {
                ResultSet rSet = c.s.executeQuery("select * from customer where number = '"+s1+"'");
                while(rSet.next()){
                    t1.setText(rSet.getString("room"));
                    room = rSet.getString("room");
                }

                ResultSet rSet2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                while(rSet2.next()){
                    t2.setText(rSet2.getString("available"));
                    t3.setText(rSet2.getString("status"));
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }else if(e.getSource() == b2){
            try{
                Conexion c = new Conexion();
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();

                String str = "update room set available = '"+available+"',status = '"+status+"' where room_number = '"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room updated Successfully");
                this.setVisible(false);

            }catch (Exception exc){
                System.out.println(exc);
            }

        }else if(e.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }


    public static void main(String[] args) {
        new UpdateRoom().setVisible(true);

    }


}
