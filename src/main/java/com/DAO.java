package com;
//necessary imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;



public class DAO

{ Connection conn;
   public DAO() throws ClassNotFoundException, SQLException
   {
       conn=DBConnection.getConnection();
       if(conn!=null)
       {
        System.out.println("Connection Established");
       }
       System.out.println("Connection not Established");


   }
//Member Function for GettingStudent
    public List<Student> getStudent() throws Exception
    {List<Student>students=new ArrayList<Student>();
        {Statement stmnt;
            try
            {
                stmnt=conn.createStatement();
                System.out.println("SSSSSSSS");
                ResultSet rs=stmnt.executeQuery("select * from datas");
                while(rs.next())
                {
                    Student newStudent;
                    newStudent=new Student();
                    newStudent.setId(rs.getInt("Id"));
                    newStudent.setFirstName(rs.getString("FirstName"));
                    newStudent.setLastName(rs.getString("LastName"));
                    newStudent.setAge(rs.getString("Age"));
                    students.add(newStudent);
                }

            }
            catch(SQLException e)
            {

             e.printStackTrace();;
            }

        }//if-bloock
        return students;


    }
//Member function for AddingStudent
    public void addStudent() throws SQLException
    {
        String sql="INSERT INTO datas(id,FirstName,LastName,Age) VALUES(?,?,?,?)";
             PreparedStatement statement = conn.prepareStatement(sql);
             statement.setString(1, "23");
            statement.setString(2, "EEEEE");
            statement.setString(3, "hiiiiiiiii");
            statement.setString(4, "25");
             int rowInserted=statement.executeUpdate();
            if(rowInserted>0)
             {
            System.out.println("Addes");
             }
    }
//Member function for UpdatingStudent
    public void updateStudent() throws SQLException
    {
        String sql="UPDATE DATAS SET FirstName=? WHERE id=14";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, "ooooo");
            int row=stmt.executeUpdate();
            if (row>0)
            {
                System.out.println("Updated");
            }
    }
//Member function for DeletingStudent
    public void deleteUser() throws SQLException
    {
        String sql="DELETE  FROM  DATAS WHERE id=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,"14");

            int row=stmt.executeUpdate();
            if (row>0)
            {
                System.out.println("Deleted");
            }
    }
}
