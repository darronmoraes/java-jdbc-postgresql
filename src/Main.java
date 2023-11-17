import java.sql.*;

public class Main {
    public static void main(String[] args) {

        /*
        * Connecting java with postgresql
        *
        * import package**
        * load and register**
        * create connection
        * create statement
        * execute statement
        * process the results
        * close
        * */

        String url = "jdbc:postgresql://localhost:5432/demo";
        String name = "postgres";
        String password = "qwerty12345";
        //String query = "Select sname FROM student WHERE sid = 2";
        String query = "Select * FROM student";

        try {
            Connection conn = DriverManager.getConnection(url, name, password);
            System.out.println("Connection Established");

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);


            //System.out.println(result.next());
            /*result.next();
            String sname = result.getString("sname");
            System.out.println("Name of student is " + sname);*/

            while (result.next()) {
                System.out.print(result.getInt("sid") + " - ");
                System.out.print(result.getString("sname") + " - ");
                System.out.print(result.getInt("marks"));
                System.out.println();
            }

            /*while (result.next()) {
                System.out.print(result.getInt(1) + " - ");
                System.out.print(result.getString(2) + " - ");
                System.out.print(result.getInt(3));
                System.out.println();
            }*/


            conn.close();
            System.out.println("Connection Closed");
        } catch (SQLException e) {
            System.out.println("Connecting To The Server" + e.getMessage());
        }
    }
}