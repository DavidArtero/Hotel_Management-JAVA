import javax.swing.*;
import java.awt.*;


public class AddDriver extends JFrame {

    JTextField t1,t2,t3;

    AddDriver(){
        JLabel title = new JLabel("Add Drivers");
        title.setBounds(150,10,150,30);
        title.setFont(new Font("Tahoma", Font.BOLD,18));
        add(title);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        name.setBounds(60,70,100,30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);


        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,14));
        age.setBounds(60,110,100,30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200,110,150,30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,14));
        gender.setBounds(60,150,100,30);
        add(gender);



        JLabel car = new JLabel("Car Company");
        car.setFont(new Font("Tahoma",Font.PLAIN,14));
        car.setBounds(60,190,100,30);
        add(car);

        JLabel model = new JLabel("Car Model");
        model.setFont(new Font("Tahoma",Font.PLAIN,14));
        model.setBounds(60,230,100,30);
        add(model);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,14));
        available.setBounds(60,270,100,30);
        add(available);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,14));
        location.setBounds(60,310,100,30);
        add(location);



        setLayout(null);
        setBounds(400,200,800,400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }
}
