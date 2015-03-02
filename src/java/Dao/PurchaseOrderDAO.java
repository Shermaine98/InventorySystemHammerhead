package Dao;

import Model.PurchaseOrder;
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

public class PurchaseOrderDAO {
    public boolean EncodePurchaseOrder(PurchaseOrder newPurchaseOrder){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into purchase_order(poNumber,itemDescription,qty,unitMeasurement,unitPrice,vat,dateMade,preparedBy,approvedBy) values (?,?,?,?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                
                
                pstmt.setInt(1, newPurchaseOrder.getPoNumber());
                pstmt.setString(2, newPurchaseOrder.getItemDescription());
                pstmt.setInt(3, newPurchaseOrder.getQty());
                pstmt.setString(4, newPurchaseOrder.getUnitMeasurement());
                pstmt.setDouble(5, newPurchaseOrder.getUnitprice());
                pstmt.setDouble(6, newPurchaseOrder.getVat());
                 pstmt.setDate(7, newPurchaseOrder.getDateMade());
                pstmt.setInt(8, newPurchaseOrder.getPreparedBy());
                 pstmt.setInt(9, newPurchaseOrder.getApprovedBy());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(PurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<PurchaseOrder> GetAllPurchaseOrder(){       
            
            ArrayList <PurchaseOrder> newPurchaseOrder= new ArrayList<PurchaseOrder>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from purchase_order");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    PurchaseOrder temp = new PurchaseOrder();
                    temp.setPoNumber(rs.getInt("poNumber"));
                    temp.setItemDescription(rs.getString("itemDescription"));
                    temp.setQty(rs.getInt("qty"));
                    temp.setUnitMeasurement(rs.getString("unitMeasurement"));
                    temp.setUnitprice(rs.getDouble("unitPrice"));
                    temp.setVat(rs.getDouble("vat"));
                    temp.setDateMade(rs.getDate("dateMade"));
                    temp.setPreparedBy(rs.getInt("preparedBy"));
                    temp.setApprovedBy(rs.getInt("approvedBy"));
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
