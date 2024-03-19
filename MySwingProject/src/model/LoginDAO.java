package model;
import model.Student;
import myconnection.MyCon;
import java.sql.*;
public class LoginDAO {
    public boolean checkLogin(String uname,String upass)
    {
       try
       {
          Connection con=null;
          con=MyCon.getConnection();
          PreparedStatement ps=null;
          ResultSet rs=null;
          String sql;
          sql="select * from login where username=? and password=?";
          ps=con.prepareStatement(sql);
          ps.setString(1, uname);
          ps.setString(2, upass);
          rs=ps.executeQuery();
          int f=0;
          while(rs.next())
          {
              f=1;
          }
           if(f==1)
               return true;
      }
       catch(Exception e)
       {
       
       }   
     return false;  
    }
    
}
