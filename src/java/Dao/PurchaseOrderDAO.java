package Dao;

import Model.PurchaseOrder;
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

public class PurchaseOrderDAO {
    public boolean EncodePurchaseOrder(PurchaseOrder newPurchaseOrder){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into supplier_purchase_order(itemDescription,supplier,type,qty,unitMeasurement,unitPrice,vat,dateMade,preparedBy,approvedBy,deliverySchedule) values (?,?,?,?,?,?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);
                
                pstmt.setString(1, newPurchaseOrder.getItemDescription());
                pstmt.setInt(2, newPurchaseOrder.getSupplier());
                pstmt.setString(3, newPurchaseOrder.getType());
                pstmt.setInt(4, newPurchaseOrder.getQty());
                pstmt.setString(5, newPurchaseOrder.getUnitMeasurement());
                pstmt.setDouble(6, newPurchaseOrder.getUnitprice());
                pstmt.setDouble(7, newPurchaseOrder.getVat());
                pstmt.setDate(8, newPurchaseOrder.getDateMade());
                pstmt.setInt(9, newPurchaseOrder.getPreparedBy());
                pstmt.setInt(10, newPurchaseOrder.getApprovedBy());
                pstmt.setDate(11, newPurchaseOrder.getDeliverySchedule());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(PurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<PurchaseOrder> GetAllPurchaseOrder() throws ParseException{       
            
            ArrayList <PurchaseOrder> newPurchaseOrder= new ArrayList<PurchaseOrder>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from supplier_purchase_order");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    PurchaseOrder temp = new PurchaseOrder();
                    temp.setPoNumber(rs.getInt("poNumber"));
                    temp.setItemDescription(rs.getString("itemDescription"));
                    temp.setSupplier(rs.getInt("supplier"));
                    temp.setQty(rs.getInt("qty"));
                    temp.setUnitMeasurement(rs.getString("unitMeasurement"));
                    temp.setUnitprice(rs.getDouble("unitPrice"));
                    temp.setVat(rs.getDouble("vat"));
                    temp.setDateMade(rs.getDate("dateMade"));
                    temp.setPreparedBy(rs.getInt("preparedBy"));
                    temp.setApprovedBy(rs.getInt("approvedBy"));
                    temp.setDeliverySchedule(rs.getDate("deliverySchedule"));
                    newPurchaseOrder.add(temp);
                }
                pstmt.close();
                conn.close();

                return newPurchaseOrder;
            } catch (SQLException ex) {
                Logger.getLogger(PurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
