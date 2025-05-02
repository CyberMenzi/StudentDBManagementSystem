
package daoapp;
import za.ac.tut.bl.StudentDB;

public class DAOApp {

   
    public static void main(String[] args) {
        String dbURL = "jdbc:derby://localhost:1527/StudentsDB";
        String username= "app";
        String password ="123";
                              
      StudentDB(dbURL, username, password);
        
    }
    
}
