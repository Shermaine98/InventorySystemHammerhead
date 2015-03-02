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
                        + "(productionNumber,stockNumber,category,consumption,unit) values (?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newCRTPI.getProductionNumber());
                pstmt.setInt(3, newCRTPI.getStockNumber());
                pstmt.setString(2, newCRTPI.getCategory());
                pstmt.setInt(4, newCRTPI.getConsumption());
                pstmt.setString(5, newCRTPI.getUnitMeasurement());
               
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
                    temp.setStockNumber(rs.getInt("stockNumber"));
                    temp.setCategory(rs.getString("category"));
                    temp.setConsumption(rs.getInt("consumption"));
                    temp.setUnitMeasurement(rs.getString("unitMeasurement"));
                    
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
