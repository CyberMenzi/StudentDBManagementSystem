
package za.ac.tut.bl;


import java.util.List;
import za.ac.tut.entity.Student;
import java.sql.*;
import java.util.ArrayList;


public class StudentDB implements DAO<Student>{

    private Connection connection;

    public StudentDB(String bdURL, String username, String password) throws SQLException{
       connection = getConnection(bdURL, username, password);
    }
    
  
    
    @Override
    public Student get(Integer code) {
        
        String sql = "SELECT StudentNumber, Name, Surname"+
                      "FROM StudentsTBL"+
                      "Where StudentNumber =?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, code);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Integer studNum = rs.getInt("StudentNumber");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                Student student = new Student(studNum, name, surname);
                rs.close();
                return student;
                } else{
                    rs.close();
                    return null;                
                }
        } catch (SQLException ex) {
            System.err.println(ex);
            return null; 
        }
        
    }

    @Override
    public List<Student> getAll() {
        
        try {
            String sql = "SELECT * FROM StudentsTBL"+
                    "ORDER BY StudentNumber ASC";
            List<Student> students = new ArrayList<>();
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Integer studNum = rs.getInt("StudentNumber");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                Student student = new Student(studNum, name, surname);
                students.add(student);    
            }
            return students;
            
            
           
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }

    
    @Override
    public boolean add(Student t) {
        
         String sql = "Insert INTO StudentsTBL(StudentNumber, Name, Surname)"+
                      "VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getStudNum());
            ps.setString(2, t.getName());
            ps.setString(3, t.getSurname());
            ps.executeUpdate();
            return true;   
        } catch (SQLException ex) {
           System.err.println(ex);
             return false;
        }
    }

    
    @Override
    public boolean update(Student t) {
        
        String sql = "UPDATE StudentsTBL SET "+
                      "Name =?"+
                      "Surname =?"+
                      "WHERE StudentNumber =?";
      
      
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getSurname());
            ps.setInt(3, t.getStudNum());
            ps.executeUpdate();
            return true;   
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
       
    }

    @Override
    public boolean delete(Student t) {
        
          try {
            String sql = "DELETE FROM StudentsTBL "+
                          "WHERE StudentNumber =?";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getStudNum());
            ps.executeQuery();
            return true;    
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;  
        } 
         
    }
    
    private Connection getConnection(String dbURL, String username, String password) throws SQLException{

        Connection theConnection = DriverManager.getConnection(dbURL, username, password);
        return theConnection;
    }
    
    
    
}

