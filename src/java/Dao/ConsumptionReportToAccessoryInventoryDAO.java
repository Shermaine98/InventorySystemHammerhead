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
                        + "(category,accessoryDescription,drNumber,productionNumber,productID,size,color,consumption,unit,productionQty) "
                        + "values (?,?,?,?,?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setString(1, newCRTAI.getCategory());
                pstmt.setString(2, newCRTAI.getAccessoryDescription());
                pstmt.setInt(3, newCRTAI.getDrNumber());
                pstmt.setInt(4, newCRTAI.getProductionNumber());
                pstmt.setInt(5, newCRTAI.getProductID());
                pstmt.setString(6, newCRTAI.getSize());
                 pstmt.setString(7, newCRTAI.getColor());
                pstmt.setInt(8, newCRTAI.getConsumption());
                pstmt.setString(9, newCRTAI.getUnit());
                pstmt.setInt(10, newCRTAI.getProductionQty());
               
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
                    temp.setCategory(rs.getString("category"));
                    temp.setAccessoryDescription(rs.getString("accessoryDescription"));
                    temp.setDrNumber(rs.getInt("drNumber"));
                    temp.setColor(rs.getString("color"));
                    temp.setProductionNumber(rs.getInt("productionNumber"));
                    temp.setProductID(rs.getInt("productID"));
                    temp.setSize(rs.getString("size"));
                    temp.setConsumption(rs.getInt("consumption"));
                    temp.setUnit(rs.getString("unit"));
                    temp.setProductionQty(rs.getInt("productionQty"));
                    
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
