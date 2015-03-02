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
import Model.DeliveryReceipt;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class DeliveryReceiptDAO {
    public boolean EncodeDeliveryReceipt(DeliveryReceipt newDeliveryReceipt){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into delivery_receipt"
                        + "(deliveryReceiptNumber,poNumber,dateReceived,checkedBy,receivedBy) values (?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newDeliveryReceipt.getDeliveryReceiptNumber());
                pstmt.setInt(2, newDeliveryReceipt.getPoNumber());
                pstmt.setDate(3, newDeliveryReceipt.getReceivedDate());
                pstmt.setInt(4, newDeliveryReceipt.getCheckedBy());
                pstmt.setInt(5, newDeliveryReceipt.getApprovedBy());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(DeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<DeliveryReceipt> GetDeliveryReceiptList(){       
            
            ArrayList <DeliveryReceipt> DeliveryReceipt = new ArrayList<DeliveryReceipt>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from delivery_receipt");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    DeliveryReceipt temp = new DeliveryReceipt();
                    temp.setDeliveryReceiptNumber(rs.getInt("deliveryReceiptNumber"));
                    temp.setPoNumber(rs.getInt("poNumber"));
                    temp.setReceivedDate(rs.getDate("dateReceived"));
                    temp.setCheckedBy(rs.getInt("checkedBy"));
                    temp.setApprovedBy(rs.getInt("receivedBy"));
                    
                    DeliveryReceipt.add(temp);
                }
                pstmt.close();
                conn.close();

                return DeliveryReceipt;
            } catch (SQLException ex) {
                Logger.getLogger(DeliveryScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
