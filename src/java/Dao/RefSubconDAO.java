
package Dao;


import Model.RefSubcon;
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

public class RefSubconDAO {


    public boolean EncodeRefSubcon(RefSubcon newRefSubcon) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into REF-subcon"
                    + "(subconID,service,companyName,companyAddress,contactPerson,contactNumber) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newRefSubcon.getSubconID());
            pstmt.setString(2, newRefSubcon.getService());
            pstmt.setString(3, newRefSubcon.getCompanyName());
            pstmt.setString(4, newRefSubcon.getCompanyAddress());
            pstmt.setString(5, newRefSubcon.getContactPerson());
            pstmt.setInt(6, newRefSubcon.getContactNumber());
            
            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(RefSubconDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<RefSubcon> MonitorRefSupplier() {
        ArrayList<RefSubcon> refSubcon = new ArrayList<RefSubcon>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REF-subcon");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RefSubcon newRefSubcon = new RefSubcon();
               
                newRefSubcon.setSubconID(rs.getInt("supplierID"));
                newRefSubcon.setService(rs.getString("itemDescription"));
                newRefSubcon.setCompanyName(rs.getString("companyName"));
                newRefSubcon.setCompanyAddress(rs.getString("companyAddress"));
                newRefSubcon.setContactPerson(rs.getString("contactPerson"));
                newRefSubcon.setContactNumber(rs.getInt("contactNumber"));
                
                refSubcon.add(newRefSubcon);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return refSubcon;
        } catch (SQLException ex) {
            Logger.getLogger(RefSubconDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    