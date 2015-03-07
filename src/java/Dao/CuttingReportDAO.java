/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.CuttingReport;
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

public class CuttingReportDAO {
    public boolean EncodeCuttingReport(CuttingReport newCuttingReport){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into cutting_report"
                        + "(productionNumber,category,drNumber,cuttingMaster,rawQty,calculatedQty,actualQty,comment) "
                        + "values (?,?,?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, newCuttingReport.getProductionNumber());
                pstmt.setString(2, newCuttingReport.getCategory());
                pstmt.setInt(3, newCuttingReport.getDrNumber());
                pstmt.setInt(4, newCuttingReport.getCuttingMaster());
                pstmt.setInt(5, newCuttingReport.getRawQty());
                pstmt.setInt(6, newCuttingReport.getCalculatedQty());
                pstmt.setInt(7, newCuttingReport.getActualQty());
                pstmt.setString(8, newCuttingReport.getComment());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(CuttingReportDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<CuttingReport> GetCuttingReportList(){       
            
            ArrayList <CuttingReport> CuttingReport = new ArrayList<CuttingReport>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from cutting_report");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    CuttingReport temp = new CuttingReport();
                    temp.setProductionNumber(rs.getInt("stockNumber"));
                    temp.setCategory(rs.getString("category"));
                    temp.setDrNumber(rs.getInt("deliveryReceiptNumber"));
                    temp.setCuttingMaster(rs.getInt("cuttingMaster"));
                    temp.setRawQty(rs.getInt("rawQty"));
                    temp.setCalculatedQty(rs.getInt("calculatedQty"));
                    temp.setActualQty(rs.getInt("actualQty"));
                    temp.setComment(rs.getString("comment"));
                    
                    CuttingReport.add(temp);
                }
                pstmt.close();
                conn.close();

                return CuttingReport;
            } catch (SQLException ex) {
                Logger.getLogger(CuttingReportDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
