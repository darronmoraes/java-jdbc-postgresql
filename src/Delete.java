import java.sql.*;

public class Delete {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String name = "postgres";
        String password = "qwerty12345";
        String deleteQuery = "delete from student where sid = 4";

        try {
            Connection conn = DriverManager.getConnection(url, name, password);
            System.out.println("Connection Established");

            Statement statement = conn.createStatement();
            statement.execute(deleteQuery);

            conn.close();
            System.out.println("Connection Closed");
        } catch (SQLException e) {
            System.out.println("Connecting To The Server" + e.getMessage());
        }
    }
}
