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
                        + "(deliveryOrderNumber,promo,outlet,productionNumber,sex,itemDescription,"
                        + "ageGroup,color,size,qty,recieved,preparedBy) values (?,?,?,?,?,?,?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newDeliveryOrder.getDeliveryOrderNumber());
                pstmt.setInt(2, newDeliveryOrder.getPromo());
                pstmt.setString(3, newDeliveryOrder.getOutlet());
                pstmt.setInt(4, newDeliveryOrder.getProductionNumber());
                pstmt.setString(5, newDeliveryOrder.getSex());
                pstmt.setString(6, newDeliveryOrder.getItemDescription());
                pstmt.setString(7, newDeliveryOrder.getAgeGroup());
                pstmt.setString(8, newDeliveryOrder.getColor());
                pstmt.setString(9, newDeliveryOrder.getSize());
                pstmt.setInt(10, newDeliveryOrder.getQty());
                pstmt.setString(11, newDeliveryOrder.getReceive());
                pstmt.setInt(12, newDeliveryOrder.getPreparedBy());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(DeliveryOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<DeliveryOrder> GetDeliveryOrderList(){       
            
            ArrayList <DeliveryOrder> DeliveryOrder = new ArrayList<DeliveryOrder>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from delivery_order");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    DeliveryOrder temp = new DeliveryOrder();
                    temp.setDeliveryOrderNumber(rs.getInt("deliveryOrderNumber"));
                    temp.setPromo(rs.getInt("promo"));
                    temp.setOutlet(rs.getString("outlet"));
                    temp.setProductionNumber(rs.getInt("productionNumber"));
                    temp.setSex(rs.getString("sex"));
                    temp.setItemDescription(rs.getString("itemDescription"));
                    temp.setAgeGroup(rs.getString("ageGroup"));
                    temp.setColor(rs.getString("color"));
                    temp.setSize(rs.getString("size"));
                    temp.setQty(rs.getInt("qty"));
                    temp.setReceive(rs.getString("received"));
                    temp.setPreparedBy(rs.getInt("preparedBy"));
                    
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
