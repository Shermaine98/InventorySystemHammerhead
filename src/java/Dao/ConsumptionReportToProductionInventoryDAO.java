/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ConsumptionReportToProductionInventory;
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

public class ConsumptionReportToProductionInventoryDAO {
    public boolean EncodeCRTAI(ConsumptionReportToProductionInventory newCRTPI){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into CR_to_PI"
                        + "(productionNumber, category, drNumber, productID, size, "
                        + "color, consumption, unit, productionQty) values (?,?,?,?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newCRTPI.getProductionNumber());
                pstmt.setString(2, newCRTPI.getCategory());
                pstmt.setInt(3, newCRTPI.getProductID());
                pstmt.setString(4, newCRTPI.getSize());
                pstmt.setString(5, newCRTPI.getColor());
                pstmt.setInt(6, newCRTPI.getConsumption());
                pstmt.setString(7, newCRTPI.getUnit());
                pstmt.setInt(8, newCRTPI.getProductionQty());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(ConsumptionReportToProductionInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<ConsumptionReportToProductionInventory> GetDeliveryReceiptList(){       
            
            ArrayList <ConsumptionReportToProductionInventory> CuttingReportToProductionInventory = new ArrayList<ConsumptionReportToProductionInventory>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from CR_to_PI");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    ConsumptionReportToProductionInventory temp = new ConsumptionReportToProductionInventory();
                    temp.setProductionNumber(rs.getInt("deliveryReceiptNumber"));
                    temp.setCategory(rs.getString("category"));
                    temp.setDrNumber(rs.getInt("drNumber"));
                    temp.setProductID(rs.getInt("productID"));
                    temp.setSize(rs.getString("size"));
                    temp.setColor(rs.getString("color"));
                    temp.setConsumption(rs.getInt("consumption"));
                    temp.setUnit(rs.getString("unit"));
                    temp.setProductionQty(rs.getInt("productionQty"));
                    
                    CuttingReportToProductionInventory.add(temp);
                }
                pstmt.close();
                conn.close();

                return CuttingReportToProductionInventory;
            } catch (SQLException ex) {
                Logger.getLogger(ConsumptionReportToProductionInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
