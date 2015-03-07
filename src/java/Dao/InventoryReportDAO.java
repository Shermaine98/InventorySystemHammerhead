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
            String query = "insert into inventory_report(promo, "
                    + "dateMade, productID, size, color, remainingQty,soldQty,pulledOutQty) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newInventoryReport.getPromo());
            pstmt.setDate(3, newInventoryReport.getDateMade());
            pstmt.setString(4, newInventoryReport.getSize());
            pstmt.setString(5, newInventoryReport.getColor());
            pstmt.setInt(6, newInventoryReport.getRemainingQuantity());
            pstmt.setInt(7, newInventoryReport.getSoldQty());
            pstmt.setInt(8, newInventoryReport.getPulledOutQty());

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
                newInventoryReport.setDateMade(rs.getDate("dateMade"));
                newInventoryReport.setProductID(rs.getInt("productID"));
                newInventoryReport.setSize(rs.getString("size"));
                newInventoryReport.setColor(rs.getString("color"));
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
