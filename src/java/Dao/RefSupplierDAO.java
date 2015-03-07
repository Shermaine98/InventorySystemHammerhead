
package Dao;


import Model.RefSupplier;
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

public class RefSupplierDAO {


    public boolean EncodeRefSupplier(RefSupplier newRefSupplier) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into REF-supplier"
                    + "(supplierID,itemDescription,companyName,companyAddress,contactPerson,contactNumber) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newRefSupplier.getSupplierID());
            pstmt.setString(2, newRefSupplier.getItemDescription());
            pstmt.setString(3, newRefSupplier.getCompanyName());
            pstmt.setString(4, newRefSupplier.getCompanyAddress());
            pstmt.setString(5, newRefSupplier.getContactPerson());
            pstmt.setInt(6, newRefSupplier.getContactNumber());
            
            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(RefSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<RefSupplier> MonitorRefSupplier() {
        ArrayList<RefSupplier> refSupplier = new ArrayList<RefSupplier>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REF-supplier");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RefSupplier newRefSupplier = new RefSupplier();
               
                newRefSupplier.setSupplierID(rs.getInt("supplierID"));
                newRefSupplier.setItemDescription(rs.getString("itemDescription"));
                newRefSupplier.setCompanyName(rs.getString("companyName"));
                newRefSupplier.setCompanyAddress(rs.getString("companyAddress"));
                newRefSupplier.setContactPerson(rs.getString("contactPerson"));
                newRefSupplier.setContactNumber(rs.getInt("contactNumber"));
                
                refSupplier.add(newRefSupplier);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return refSupplier;
        } catch (SQLException ex) {
            Logger.getLogger(RefSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    