package Utilities;

import java.sql.DriverManager;

public class manageDB extends commonOps
{
    public static void initConnection(String dbURL, String user, String pass)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL,user,pass);
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            System.out.println("Error Occured while connecting to DB, See details: " + e);
        }
    }

    public static void closeConnection()
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error Occured while Closing DB, See details: " + e);
        }
    }
}
