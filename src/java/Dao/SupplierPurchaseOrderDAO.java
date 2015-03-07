
package Dao;


import Model.SupplierPurchaseOrder;
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

public class SupplierPurchaseOrderDAO {


    public boolean EncodeSupplierPurchaseOrder(SupplierPurchaseOrder newSupplierPurchaseOrder) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into supplier_purchase_order"
                    + "(poNumber,itemDescription,supplier,type,qty,unitMeasurement,unitPrice,VAT,dateMade,preparedBy,ApprovedBy,deliverySchedule) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSupplierPurchaseOrder.getPoNumber());
            pstmt.setString(2, newSupplierPurchaseOrder.getItemDescription());
            pstmt.setInt(3, newSupplierPurchaseOrder.getSupplier());
            pstmt.setString(4, newSupplierPurchaseOrder.getType());
            pstmt.setInt(5, newSupplierPurchaseOrder.getQty());
            pstmt.setString(6, newSupplierPurchaseOrder.getUnitMeasurement());
            pstmt.setDouble(7, newSupplierPurchaseOrder.getUnitprice());
            pstmt.setDouble(8, newSupplierPurchaseOrder.getVat());
            pstmt.setDate(9, newSupplierPurchaseOrder.getDateMade());
            pstmt.setInt(10, newSupplierPurchaseOrder.getPreparedBy());
            pstmt.setInt(11, newSupplierPurchaseOrder.getApprovedBy());
            pstmt.setDate(12, newSupplierPurchaseOrder.getDeliverySchedule());
            
            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SupplierPurchaseOrder> MonitorSupplierPurchaseOrder() {
        ArrayList<SupplierPurchaseOrder> supplierPurchaseOrder = new ArrayList<SupplierPurchaseOrder>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM supplier_purchase_order");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SupplierPurchaseOrder newSupplierPurchaseOrder = new SupplierPurchaseOrder();
                
                newSupplierPurchaseOrder.setPoNumber(rs.getInt("poNumber"));
                newSupplierPurchaseOrder.setItemDescription(rs.getString("itemDescription"));
                newSupplierPurchaseOrder.setSupplier(rs.getInt("qty"));
                newSupplierPurchaseOrder.setType(rs.getString("type"));
                newSupplierPurchaseOrder.setQty(rs.getInt("qty"));
                newSupplierPurchaseOrder.setUnitMeasurement(rs.getString("unitMeasurement"));
                newSupplierPurchaseOrder.setUnitprice(rs.getDouble("unitPrice"));
                newSupplierPurchaseOrder.setVat(rs.getDouble("VAT"));
                newSupplierPurchaseOrder.setDateMade(rs.getDate("dateMade"));
                newSupplierPurchaseOrder.setPreparedBy(rs.getInt("preparedBy"));
                newSupplierPurchaseOrder.setApprovedBy(rs.getInt("ApprovedBy"));
                newSupplierPurchaseOrder.setDeliverySchedule(rs.getDate("deliverySchedule"));
                
                supplierPurchaseOrder.add(newSupplierPurchaseOrder);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return supplierPurchaseOrder;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    