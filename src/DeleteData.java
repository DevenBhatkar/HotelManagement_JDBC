import java.sql.*;

public class DeleteData
{
    public static void main(String[] args) throws ClassNotFoundException {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="2106";
        String query="delete from employees where id in (3,4);";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded sucessfully");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("connection established sucessfully!!");
            Statement stmt=con.createStatement();
            int rowAffected=stmt.executeUpdate(query);

            if(rowAffected>0)
            {
                System.out.println("Deletion successful "+rowAffected+" row(s) affected");
            }
            else
            {
                System.out.println("Deletion failed");
            }



            stmt.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}