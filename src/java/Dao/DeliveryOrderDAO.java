/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.DeliveryOrder;
import java.text.ParseException;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class DeliveryOrderDAO {
    public boolean EncodeDeliveryOrder(DeliveryOrder newDeliveryOrder){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into delivery_order"
                        + "(doNumber, promo, dateMade, productID, size, color, deliveryQty, "
                        + "approved, preparedBy, approvedBy) values (?,?,?,?,?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newDeliveryOrder.getDoNumber());
                pstmt.setInt(2, newDeliveryOrder.getPromo());
                pstmt.setDate(3, newDeliveryOrder.getDateMade());
                pstmt.setInt(4, newDeliveryOrder.getProductID());
                pstmt.setString(5, newDeliveryOrder.getSize());
                pstmt.setString(6, newDeliveryOrder.getColor());
                pstmt.setInt(7, newDeliveryOrder.getDeliveryQty());
                pstmt.setBoolean(8, newDeliveryOrder.isApproved());
                pstmt.setInt(9, newDeliveryOrder.getPreparedBy());
                pstmt.setInt(10, newDeliveryOrder.getApprovedBy());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(DeliveryOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<DeliveryOrder> GetDeliveryOrderList() throws ParseException{       
            
            ArrayList <DeliveryOrder> DeliveryOrder = new ArrayList<DeliveryOrder>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from delivery_order");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    DeliveryOrder temp = new DeliveryOrder();
                    temp.setDoNumber(rs.getInt("doNumber"));
                    temp.setPromo(rs.getInt("promo"));
                    temp.setDateMade();
                    temp.setProductID(rs.getInt("productID"));
                    temp.setSize(rs.getString("size"));
                    temp.setColor(rs.getString("color"));
                    temp.setDeliveryQty(rs.getInt("deliveryQty"));
                    temp.setApproved(rs.getBoolean("approved"));
                    temp.setPreparedBy(rs.getInt("preparedBy"));
                    temp.setApprovedBy(rs.getInt("approvedBy"));
                    
                    DeliveryOrder.add(temp);
                }
                pstmt.close();
                conn.close();

                return DeliveryOrder;
            } catch (SQLException ex) {
                Logger.getLogger(DeliveryOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
