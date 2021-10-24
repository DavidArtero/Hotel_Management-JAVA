import java.sql.*;

public class Conexion {
    Connection c;
    Statement s;

    public Conexion(){

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql:///projecthms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
                s = c.createStatement();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

    }


}
