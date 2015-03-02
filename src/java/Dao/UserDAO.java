package Dao;

import Model.User;
import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class UserDAO {
   
    public boolean register(User newUser){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into user(employeeNumber,lastName,firstName,userName,password,position) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, newUser.getEmployeeNumber());
            pstmt.setString(2, newUser.getLastName());
            pstmt.setString(3, newUser.getFirstName());
            pstmt.setString(4, newUser.getUserName());
            pstmt.setString(5, newUser.getPassword());
            pstmt.setString(6, newUser.getPosition());
      
            
            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean authenticate(User User){
        boolean valid = false;
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
  
            String query = "select * from user where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
          
            pstmt.setString(1, User.getUserName());
            pstmt.setString(2, User.getPassword());
           
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                valid = true;
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
        return valid;
    }
   
}

