import java.sql.*;

public class Insert {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String name = "postgres";
        String password = "qwerty12345";
        String insertQuery = "insert into student values (4, 'John', 48)";

        try {
            Connection conn = DriverManager.getConnection(url, name, password);
            System.out.println("Connection Established");

            Statement statement = conn.createStatement();
            boolean status = statement.execute(insertQuery);
            System.out.println(status);

            conn.close();
            System.out.println("Connection Closed");
        } catch (SQLException e) {
            System.out.println("Connecting To The Server" + e.getMessage());
        }
    }
}
