
package Dao;


import Model.SupplierDeliveryReceipt;
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

public class SupplierDeliveryReceiptDAO {


    public boolean EncodeSupplierDeliveryReceipt(SupplierDeliveryReceipt newSupplierDeliveryReceipt) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into supplier_delivery_receipt"
                    + "(drNumber,poNumber,itemDescription,dateReceived,checkedBy,receivedBy,status,qty,comment) "
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSupplierDeliveryReceipt.getDeliveryReceiptNumber());
            pstmt.setInt(2, newSupplierDeliveryReceipt.getPoNumber());
            pstmt.setString(3, newSupplierDeliveryReceipt.getItemDescription());
            pstmt.setDate(4, newSupplierDeliveryReceipt.getReceivedDate());
            pstmt.setInt(5, newSupplierDeliveryReceipt.getCheckedBy());
            pstmt.setInt(6, newSupplierDeliveryReceipt.getApprovedBy());
            pstmt.setString(4, newSupplierDeliveryReceipt.getStatus());
            pstmt.setInt(5, newSupplierDeliveryReceipt.getQty());
            pstmt.setString(6, newSupplierDeliveryReceipt.getComment());
            
            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SupplierDeliveryReceipt> MonitorSupplierDeliveryReceipt() {
        ArrayList<SupplierDeliveryReceipt> supplierDeliveryReceipt = new ArrayList<SupplierDeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM supplier_delivery_receipt");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SupplierDeliveryReceipt newSupplierDeliveryReceipt = new SupplierDeliveryReceipt();
                
                newSupplierDeliveryReceipt.setDeliveryReceiptNumber(rs.getInt("doNumber"));
                newSupplierDeliveryReceipt.setPoNumber(rs.getInt("poNumber"));
                newSupplierDeliveryReceipt.setItemDescription(rs.getString("itemDescription"));
                newSupplierDeliveryReceipt.setReceivedDate(rs.getDate("dateReceived"));
                newSupplierDeliveryReceipt.setCheckedBy(rs.getInt("checkedBy"));
                newSupplierDeliveryReceipt.setApprovedBy(rs.getInt("receivedBy"));
                newSupplierDeliveryReceipt.setStatus(rs.getString("status"));
                newSupplierDeliveryReceipt.setQty(rs.getInt("qty"));
                newSupplierDeliveryReceipt.setComment(rs.getString("comment"));
                
                supplierDeliveryReceipt.add(newSupplierDeliveryReceipt);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return supplierDeliveryReceipt;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    