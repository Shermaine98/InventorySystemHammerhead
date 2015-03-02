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
                        + "(deliveryOrderNumber,schedule,preparedBy,driver) values (?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newDeliverySchedule.getDeliveryOrderNumber());
                pstmt.setDate(2, newDeliverySchedule.getDate());
                pstmt.setInt(3, newDeliverySchedule.getPreparedBy());
                pstmt.setInt(4, newDeliverySchedule.getDriver());
               
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
