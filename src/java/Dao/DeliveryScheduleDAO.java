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
import Model.DeliverySchedule;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class DeliveryScheduleDAO {
     public boolean EncodeDeliverySchedule(DeliverySchedule newDeliverySchedule){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into delivery_schedule"
                        + "(doNumber,promo,driver,dateMade,boxQty) values (?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newDeliverySchedule.getDeliveryOrderNumber());
                pstmt.setInt(2, newDeliverySchedule.getPromo());
                pstmt.setInt(3, newDeliverySchedule.getDriver());
                pstmt.setDate(4, newDeliverySchedule.getDate());
                pstmt.setInt(5, newDeliverySchedule.getBoxQty());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(DeliveryScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<DeliverySchedule> GetDeliveryScheduleList(){       
            
            ArrayList <DeliverySchedule> DeliverySchedule = new ArrayList<DeliverySchedule>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from delivery_schedule");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    DeliverySchedule temp = new DeliverySchedule();
                    temp.setDeliveryOrderNumber(rs.getInt("deliveryOrderNumber"));
                    temp.setDate(rs.getDate("schedule"));
                    temp.setPreparedBy(rs.getInt("preparedBy"));
                    temp.setDriver(rs.getInt("driver"));
                    
                    temp.setDeliveryOrderNumber(rs.getInt("deliveryOrderNumber"));
                    temp.setPromo(rs.getInt("promo"));
                    temp.setDriver(rs.getInt("driver"));
                    temp.setDate(rs.getDate("dateMade"));
                    temp.setBoxQty(rs.getInt("boxQty"));
                    
                    DeliverySchedule.add(temp);
                }
                pstmt.close();
                conn.close();

                return DeliverySchedule;
            } catch (SQLException ex) {
                Logger.getLogger(DeliveryScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
