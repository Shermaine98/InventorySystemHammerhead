package Dao;

import Model.InventoryReport;
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


public class InventoryReportDAO {

    public boolean EncodeInventoryReport(InventoryReport newInventoryReport) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into inventory_report(promo,outlet,dateMade,productionNumber,sex,itemDescription,ageGroup,color,size,remainingQty,soldQty,pulledOutQty) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newInventoryReport.getPromo());
            pstmt.setString(2, newInventoryReport.getOutlet());
            pstmt.setDate(3, newInventoryReport.getDateMade());
            pstmt.setInt(4, newInventoryReport.getProductionNumber());
            pstmt.setString(5, newInventoryReport.getSex());
            pstmt.setString(6, newInventoryReport.getItemDescription());
            pstmt.setString(7, newInventoryReport.getAgeGroup());
            pstmt.setString(8, newInventoryReport.getColor());
            pstmt.setString(9, newInventoryReport.getSize());
            pstmt.setDouble(10, newInventoryReport.getRemainingQuantity());
            pstmt.setInt(11, newInventoryReport.getSoldQty());
            pstmt.setInt(12, newInventoryReport.getPulledOutQty());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(InventoryReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<InventoryReport> GetAllInventoryReport() {
        ArrayList<InventoryReport> InventoryReport = new ArrayList<InventoryReport>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventory_report");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                InventoryReport newInventoryReport = new InventoryReport();
                newInventoryReport.setPromo(rs.getInt("promo"));
                newInventoryReport.setOutlet(rs.getString("outlet"));
                newInventoryReport.setDateMade(rs.getDate("dateMade"));
                newInventoryReport.setProductionNumber(rs.getInt("productionNumber"));
                newInventoryReport.setSex(rs.getString("sex"));
                newInventoryReport.setItemDescription(rs.getString("itemDescription"));
                newInventoryReport.setAgeGroup(rs.getString("ageGroup"));
                newInventoryReport.setColor(rs.getString("color"));
                newInventoryReport.setSize(rs.getString("size"));
                newInventoryReport.setRemainingQuantity(rs.getInt("remainingQty"));
                newInventoryReport.setSoldQty(rs.getInt("soldQty"));
                newInventoryReport.setPulledOutQty(rs.getInt("pulledOutQty"));

                InventoryReport.add(newInventoryReport);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return InventoryReport;
        } catch (SQLException ex) {
            Logger.getLogger(InventoryReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
