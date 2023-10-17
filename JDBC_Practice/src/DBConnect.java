import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:mysql://localhost/office";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection connect = null;

        //identify sql query
        String sql = "SELECT * FROM employees";

        try {
            //connect to driver
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //compose a sql statement
            Statement st = connect.createStatement();

            //run and set sql query to ResultSet
            ResultSet data = st.executeQuery(sql);


            //print the data from database
            System.out.println("THE EMPLOYEE LIST OF NBC FILM");
            System.out.println("-------------------------------------------");
            while (data.next()) {
                System.out.println("Employee Id: " + data.getInt("id"));
                System.out.println("Employee Name: " + data.getString("name"));
                System.out.println("Employee Position: " + data.getString("position"));
                System.out.println("Employee Salary: " + data.getInt("salary"));
                System.out.println("-------------------------------------------");
            }

            st.close();
            connect.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
