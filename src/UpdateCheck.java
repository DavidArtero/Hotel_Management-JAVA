import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;

    UpdateCheck() {

        JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setBounds(20, 30, 200, 30);
        add(l1);

        //Customer ID
        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(30,80,100,20);
        add(l2);

        c1 = new Choice();

        try{
            Conexion c = new Conexion();
            ResultSet rSet = c.s.executeQuery("select * from customer");

            while(rSet.next()){
                c1.add(rSet.getString("number"));
            }
        }catch (Exception exc){
           exc.getStackTrace();
        }

        c1.setBounds(200,80,150,25);
        add(c1);


        //Room Number
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,120,100,20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);

        //Name
        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,160,100,20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);


        //Check in
        JLabel l5 = new JLabel("Check-In");
        l5.setBounds(30,200,100,20);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);


        //Amount Paid
        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30,240,100,20);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);

        //Pending Amount
        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(30,280,100,25);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);


        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,340,100,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150,340,100,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(270,340,100,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel l9 = new JLabel(i1);
        l9.setBounds(400,50,500,300);
        add(l9);

        getContentPane().setBackground(Color.WHITE);


        setLayout(null);
        setBounds(500, 200, 980, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){

            try{
                String room = null;
                String deposit = null;
                int amountPaid;
                String price = null;
                Conexion c = new Conexion();
                String id = c1.getSelectedItem();
                String str = "select * from customer where number = '"+id+"'";
                ResultSet rSet = c.s.executeQuery(str);

                while(rSet.next()){
                    t1.setText(rSet.getString("room"));//number
                    t2.setText(rSet.getString("name"));
                    t3.setText(rSet.getString("status"));
                    t4.setText(rSet.getString("deposit"));
                    room = rSet.getString("room");
                    deposit = rSet.getString("deposit");
                }

                ResultSet rSet2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");

                while(rSet2.next()){
                    price = rSet2.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));

                }

            }catch (Exception ex){
                ex.getStackTrace();
            }



        }else if(e.getSource() == b2){

        }else if(e.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }


}
