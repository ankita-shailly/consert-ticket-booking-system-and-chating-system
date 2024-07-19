package managementsys;
import java.sql.*;
public class adcon {
    Connection c;
    Statement s;
    public adcon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/concertsmsystem","root","roota");
            s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
