import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCheck extends JFrame implements ActionListener {
    //https://www.youtube.com/watch?v=Is7TZ81hVFU

    UpdateCheck() {

        JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setBounds(20, 30, 200, 30);

        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(30,80,100,20);
        add(l2);


        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,80,100,20);
        add(l3);


        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,80,100,20);
        add(l4);

        JLabel l5 = new JLabel("Check-In");
        l5.setBounds(30,80,100,20);
        add(l5);

        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30,80,100,20);
        add(l6);

        JLabel l7 = new JLabel("Pending Amount");
        l6.setBounds(30,80,100,20);
        add(l7);






        setLayout(null);
        setBounds(20, 30, 200, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }


}
