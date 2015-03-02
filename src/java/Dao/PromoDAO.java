package Dao;

import Model.Promo;
import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class PromoDAO {

   
    public boolean RegisterPromo(Promo newPromo) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            int rows;
            try (Connection conn = myFactory.getConnection()) {
                String query = "insert into promo(employeeNumber, outlet,address,city) values (?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, newPromo.getEmployeeNumber());
                pstmt.setString(2, newPromo.getOutlet());
                pstmt.setString(3, newPromo.getAddress());
                pstmt.setString(3, newPromo.getCity());
                rows = pstmt.executeUpdate();
            }
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PromoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Promo> GetAllPromo() {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            ArrayList<Promo> Promo;
            try (Connection conn = myFactory.getConnection(); 
               PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM promo")) {
                Promo = new ArrayList<>();
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Promo newPromo = new Promo();
                    newPromo.setEmployeeNumber(rs.getInt("employeeNumber"));
                    newPromo.setOutlet(rs.getString("outlet"));
                    newPromo.setAddress(rs.getString("address"));
                    newPromo.setCity(rs.getString("city"));
                    Promo.add(newPromo);
                    
                }              }
            return Promo;
        } catch (SQLException ex) {
            Logger.getLogger(PromoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}


