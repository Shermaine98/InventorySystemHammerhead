
package Dao;


import Model.SubconPurchaseOrder;
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

public class SubconPurchaseOrderDAO {


    public boolean EncodeSubconPurchaseOrder(SubconPurchaseOrder newSubconPurchaseOrder) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into subcon_purchase_order"
                    + "(poNumber,productionNumber,productID,size,color,subcon,qty,"
                    + "service,unitPrice,dateMade,preparedBy,ApprovedBy,deliverySchedule) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSubconPurchaseOrder.getPoNumber());
            pstmt.setInt(2, newSubconPurchaseOrder.getProductionNumber());
            pstmt.setInt(3, newSubconPurchaseOrder.getProductID());
            pstmt.setString(4, newSubconPurchaseOrder.getSize());
            pstmt.setString(5, newSubconPurchaseOrder.getColor());
            pstmt.setInt(6, newSubconPurchaseOrder.getSubcon());
            pstmt.setInt(7, newSubconPurchaseOrder.getQty());
            pstmt.setString(8, newSubconPurchaseOrder.getService());
            pstmt.setDouble(9, newSubconPurchaseOrder.getUnitPrice());
            pstmt.setDate(10, newSubconPurchaseOrder.getDateMade());
            pstmt.setInt(11, newSubconPurchaseOrder.getPreparedBy());
            pstmt.setInt(12, newSubconPurchaseOrder.getApprovedBy());
            pstmt.setDate(13, newSubconPurchaseOrder.getDeliverySchedule());
            
            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SubconPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SubconPurchaseOrder> MonitorSubconPurchaseOrder() throws ParseException {
        ArrayList<SubconPurchaseOrder> SubconPurchaseOrder = new ArrayList<SubconPurchaseOrder>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM subcon_purchase_order");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SubconPurchaseOrder newSubconPurchaseOrder = new SubconPurchaseOrder();
                
                newSubconPurchaseOrder.setPoNumber(rs.getInt("poNumber"));
                newSubconPurchaseOrder.setProductionNumber(rs.getInt("productionNumber"));
                newSubconPurchaseOrder.setProductID(rs.getInt("productID"));
                newSubconPurchaseOrder.setSize(rs.getString("size"));
                newSubconPurchaseOrder.setColor(rs.getString("color"));
                newSubconPurchaseOrder.setSubcon(rs.getInt("subcon"));
                newSubconPurchaseOrder.setQty(rs.getInt("qty"));
                newSubconPurchaseOrder.setService(rs.getString("service"));
                newSubconPurchaseOrder.setUnitPrice(rs.getDouble("unitPrice"));
                newSubconPurchaseOrder.setDateMade();
                newSubconPurchaseOrder.setPreparedBy(rs.getInt("preparedBy"));
                newSubconPurchaseOrder.setApprovedBy(rs.getInt("ApprovedBy"));
                newSubconPurchaseOrder.setDeliverySchedule();
                
                SubconPurchaseOrder.add(newSubconPurchaseOrder);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return SubconPurchaseOrder;
        } catch (SQLException ex) {
            Logger.getLogger(SubconPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    