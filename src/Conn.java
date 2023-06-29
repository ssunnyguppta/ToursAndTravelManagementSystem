// JDBC = JAVA DATABASE CONNECTIVITY

// 5 Steps of Database Connectivity

/*1) Register the Driver Class.
  2) Creating Connection String.
  3) Creating the Statement.
  4) Executing Mysql quries.
  5) Using the connection.
*/
import java.sql.*; // FOR CONNECTION C (13).

public class Conn {

    // to create a connection string, create a interface called as CONNECTION C.
    Connection c;

    // to create a statement, define a statement
    Statement s;
    Conn(){
        try {
            // Registering the Driver : It means giving the path of our database.
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "Sunny@2001");
            s = c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}