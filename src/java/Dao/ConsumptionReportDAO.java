/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ConsumptionReport;
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

public class ConsumptionReportDAO {
    public boolean EncodeConsumptionReport(ConsumptionReport newConsumptionReport){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into consumption_report"
                        + "(productionNumber, productionQty, preparedBy, approvedBy, dateMade) values (?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newConsumptionReport.getProductionNumber());
                pstmt.setInt(2, newConsumptionReport.getProdQty());
                pstmt.setInt(3, newConsumptionReport.getPreparedBy());
                pstmt.setInt(4, newConsumptionReport.getApprovedBy());
                pstmt.setDate(5, newConsumptionReport.getdateMade());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(ConsumptionReportDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<ConsumptionReport> GetConsumptionReportList(){       
            
            ArrayList <ConsumptionReport> ConsumptionReport = new ArrayList<ConsumptionReport>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from consumption_report");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    ConsumptionReport temp = new ConsumptionReport();
                    temp.setProductionNumber(rs.getInt("productionNumber"));
                    temp.setProdQty(rs.getInt("productionQty"));
                    temp.setPreparedBy(rs.getInt("preparedBy"));
                    temp.setApprovedBy(rs.getInt("approvedBy"));
                    temp.setdateMade(rs.getDate("dateMade"));
                    
                    ConsumptionReport.add(temp);
                }
                pstmt.close();
                conn.close();

                return ConsumptionReport;
            } catch (SQLException ex) {
                Logger.getLogger(ConsumptionReportDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
