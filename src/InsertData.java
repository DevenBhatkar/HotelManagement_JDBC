import java.sql.*;

public class InsertData
{
    public static void main(String[] args) throws ClassNotFoundException {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="2106";
        String query="insert into employees(id,name,job_title,salary) values(4,'ujjwal','react developer',77000)";


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
                System.out.println("Insert successful "+rowAffected+" row(s) affected");
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