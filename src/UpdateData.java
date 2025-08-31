import java.sql.*;

public class UpdateData
{
    public static void main(String[] args) throws ClassNotFoundException {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="2106";
        String query="update employees\n" +
                "set job_title ='full stack developer',salary=70000.0\n" +
                "where id=2;";


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
                System.out.println("update successful "+rowAffected+" row(s) affected");
            }
            else
            {
                System.out.println("update failed");
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