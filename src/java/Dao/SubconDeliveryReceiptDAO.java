
package Dao;


import Model.SubconDeliveryReceipt;
import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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

public class SubconDeliveryReceiptDAO {


    public boolean EncodeSubconDeliveryReceipt(SubconDeliveryReceipt newSubconDeliveryReceipt) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into subcon_delivery_receipt"
                    + "(drNumber,productionNumber,productID,size,color,poNumber,dateReceived,"
                    + "checkedBy,recievedBy,status,qty,comment) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSubconDeliveryReceipt.getDrNumber());
            pstmt.setInt(2, newSubconDeliveryReceipt.getProductionNumber());
            pstmt.setInt(3, newSubconDeliveryReceipt.getProductID());
            pstmt.setString(4, newSubconDeliveryReceipt.getSize());
            pstmt.setString(5, newSubconDeliveryReceipt.getColor());
            pstmt.setInt(6, newSubconDeliveryReceipt.getPoNumber());
            pstmt.setDate(7, newSubconDeliveryReceipt.getDateRecieved());
            pstmt.setInt(8, newSubconDeliveryReceipt.getCheckedBy());
            pstmt.setInt(9, newSubconDeliveryReceipt.getReceivedBy());
            pstmt.setString(10, newSubconDeliveryReceipt.getStatus());
            pstmt.setInt(11, newSubconDeliveryReceipt.getQty());
            pstmt.setString(12, newSubconDeliveryReceipt.getComment());
            
            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SubconDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SubconDeliveryReceipt> MonitorDeliveryReceipt() throws ParseException {
        ArrayList<SubconDeliveryReceipt> SubconDeliveryReceipt = new ArrayList<SubconDeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM subcon_delivery_receipt");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SubconDeliveryReceipt newSubconDeliveryReceipt = new SubconDeliveryReceipt();
                
                newSubconDeliveryReceipt.setDrNumber(rs.getInt("drNumber"));
                newSubconDeliveryReceipt.setProductionNumber(rs.getInt("productionNumber"));
                newSubconDeliveryReceipt.setProductID(rs.getInt("productID"));
                newSubconDeliveryReceipt.setSize(rs.getString("size"));
                newSubconDeliveryReceipt.setColor(rs.getString("color"));
                newSubconDeliveryReceipt.setPoNumber(rs.getInt("poNumber"));
                newSubconDeliveryReceipt.setDateReceived(rs.getDate("dateReceived"));
                newSubconDeliveryReceipt.setCheckedBy(rs.getInt("checkedBy"));
                newSubconDeliveryReceipt.setReceivedBy(rs.getInt("receivedBy"));
                newSubconDeliveryReceipt.setStatus(rs.getString("status"));
                newSubconDeliveryReceipt.setQty(rs.getInt("qty"));
                newSubconDeliveryReceipt.setComment(rs.getString("comment"));
                
                SubconDeliveryReceipt.add(newSubconDeliveryReceipt);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return SubconDeliveryReceipt;
        } catch (SQLException ex) {
            Logger.getLogger(SubconDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    