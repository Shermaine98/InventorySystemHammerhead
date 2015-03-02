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
import Model.ConsumptionReportToAccessoriesInventory;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class ConsumptionReportToAccessoryInventoryDAO {
    public boolean EncodeCRTAI(ConsumptionReportToAccessoriesInventory newCRTAI){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into CR_to_AI"
                        + "(productionNumber,category,accessoryDescription,consumption,unit) values (?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newCRTAI.getProductionNumber());
                pstmt.setString(2, newCRTAI.getCategory());
                pstmt.setString(3, newCRTAI.getAccessoryDescription());
                pstmt.setInt(4, newCRTAI.getConsumption());
                pstmt.setString(5, newCRTAI.getUnit());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(ConsumptionReportToAccessoryInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<ConsumptionReportToAccessoriesInventory> GetDeliveryReceiptList(){       
            
            ArrayList <ConsumptionReportToAccessoriesInventory> CuttingReportToAccessoriesInventory = new ArrayList<ConsumptionReportToAccessoriesInventory>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from CR_to_AI");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    ConsumptionReportToAccessoriesInventory temp = new ConsumptionReportToAccessoriesInventory();
                    temp.setProductionNumber(rs.getInt("deliveryReceiptNumber"));
                    temp.setCategory(rs.getString("category"));
                    temp.setAccessoryDescription(rs.getString("accessoryDescription"));
                    temp.setConsumption(rs.getInt("consumption"));
                    temp.setUnit(rs.getString("unit"));
                    
                    CuttingReportToAccessoriesInventory.add(temp);
                }
                pstmt.close();
                conn.close();

                return CuttingReportToAccessoriesInventory;
            } catch (SQLException ex) {
                Logger.getLogger(ConsumptionReportToAccessoriesInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
