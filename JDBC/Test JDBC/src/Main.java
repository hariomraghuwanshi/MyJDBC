// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username ="root";
        String password = "******";
        String query = "Select * from employees;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully !!!");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());

        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established succesfully !!!");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                Double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("=====================");
                System.out.println("ID: "+ id);
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title);
                System.out.println("Salary: "+salary);

            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed  successfully!!!");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
