package model;
import java.sql.*;
import java.util.*;
import myconnection.MyCon;
public class StudentDAO 
{
    Connection con=null;
    PreparedStatement ps=null;
    String sql;
    public boolean insertStudent(Student S) throws Exception
    {
         con=MyCon.getConnection();
         PreparedStatement ps=null;
         
         sql="insert into student values(?,?,?,?,?)";
         ps=con.prepareStatement(sql);
         ps.setInt(1, S.getRno());
         ps.setString(2, S.getName());
         ps.setInt(3, S.getPhy());
         ps.setInt(4, S.getChem());
         ps.setInt(5, S.getMath());
         if(ps.executeUpdate()>0)
             return true;
         else
             return false;
    }   
    
    public boolean deleteStudent(int rno) throws Exception
    {
      
      con=MyCon.getConnection();
      sql="delete from student where rollno=?";
      ps=con.prepareStatement(sql);
      ps.setInt(1, rno);
         if(ps.executeUpdate()>0)
             return true;
         else
             return false;
    }  
    public Student searchStudent(int rno) throws Exception
    {
               con=MyCon.getConnection();
             ResultSet rs;
              sql="select * from student where rollno=?";
             ps=con.prepareStatement(sql);
             ps.setInt(1, rno);
             rs=ps.executeQuery();
             Student S=new Student();
            int f=0;
             while(rs.next())
             {     
                 f=1;
                 S.setRno(rs.getInt(1));
                 S.setName(rs.getString(2));
                 S.setPhy(rs.getInt(3));
                 S.setChem(rs.getInt(4));
                 S.setMath(rs.getInt(5));
            }       
             if(f==1)
             return(S);
             
             return null;
        }
    
    public boolean updateStudent(Student S) throws Exception
    {
        con=MyCon.getConnection();
        sql="update student set rollno=?,name=?,physics=?,chem=?,math=? where rollno=?";
        
      ps=con.prepareStatement(sql);
          ps.setInt(1, S.getRno());
         ps.setString(2, S.getName());
         ps.setInt(3, S.getPhy());
         ps.setInt(4, S.getChem());
         ps.setInt(5, S.getMath());
          ps.setInt(6, S.getRno());
         if(ps.executeUpdate()>0)
             return true;
         else
             return false;
    }
    public List<Student> serachAllStudent() throws Exception
    {
           con=MyCon.getConnection();
             ResultSet rs;
             sql="select * from student";
             
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
             List<Student> mylist=new ArrayList<Student>();
             
             while(rs.next())
             {
                 Student S=new Student();
                 S.setRno(rs.getInt(1));
                 S.setName(rs.getString(2));
                 S.setPhy(rs.getInt(3));
                 S.setChem(rs.getInt(4));
                 S.setMath(rs.getInt(5));
                 mylist.add(S);
                 S=null;
             }   
           return mylist;
    }
   public int maxrecord() throws Exception
    {
          con=MyCon.getConnection();
             ResultSet rs;
             sql="select max(rollno) from student";
             
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
             int rn=99;
             while(rs.next())
             {
                 rn=rs.getInt(1);
             }   
        
             rn=rn+1;
             return(rn);
    }        
    
    }
