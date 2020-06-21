package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Class reponsible for settingConnection with DB
public class DBConnection
{ public static Connection con;
   public static Connection getConnection() throws SQLException, ClassNotFoundException
   {
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3309/student","root","root");
    return con;
   }
}
