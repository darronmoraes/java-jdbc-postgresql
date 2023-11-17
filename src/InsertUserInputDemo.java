import java.sql.*;

public class InsertUserInputDemo {

    public static void main(String[] args) {

        int sid = 105;
        String studentName = "Jasmine";
        int studentMarks = 15;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String name = "postgres";
        String password = "qwerty12345";
        String insertQuery = "insert into student values (?, ?, ?)";
        //String insertQuery = "insert into student values (" + sid + ", '" + studentName + "', " +  studentMarks + ")";

        try {
            Connection conn = DriverManager.getConnection(url, name, password);
            System.out.println("Connection Established");

            PreparedStatement statement = conn.prepareStatement(insertQuery);
            statement.setInt(1, sid);
            statement.setString(2, studentName);
            statement.setInt(3, studentMarks);
            statement.execute();

            conn.close();
            System.out.println("Connection Closed");
        } catch (SQLException e) {
            System.out.println("Connecting To The Server" + e.getMessage());
        }
    }

}
