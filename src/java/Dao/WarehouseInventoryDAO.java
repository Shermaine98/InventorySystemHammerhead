
package Dao;


import Model.WarehouseInventory;
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

public class WarehouseInventoryDAO {


    public boolean EncodeWarehouseInventory(WarehouseInventory newWarehouseInventory) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into warehouse_inventory(productionNumber,sex,itemDescription,ageGroup,color,size,dateUpdated,qty) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

       
            pstmt.setInt(1, newWarehouseInventory.getProductionNumber());
            pstmt.setString(2, newWarehouseInventory.getSex());
            pstmt.setString(3, newWarehouseInventory.getItemDescription());
            pstmt.setString(4, newWarehouseInventory.getAgeGroup());
            pstmt.setString(5, newWarehouseInventory.getColor());
            pstmt.setString(6, newWarehouseInventory.getSize());
            pstmt.setDate(7, newWarehouseInventory.getDateUpdated());
            pstmt.setInt(8, newWarehouseInventory.getQty());
            

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(InventoryReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<WarehouseInventory> MonitorWarehouseInventory() {
        ArrayList<WarehouseInventory> warehouseInventory = new ArrayList<WarehouseInventory>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM warehouse_inventory");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                WarehouseInventory newwarehouseInventory = new WarehouseInventory();
               
                newwarehouseInventory.setProductionNumber(rs.getInt("productionNumber"));
                newwarehouseInventory.setSex(rs.getString("sex"));
                newwarehouseInventory.setItemDescription(rs.getString("itemDescription"));
                newwarehouseInventory.setAgeGroup(rs.getString("ageGroup"));
                newwarehouseInventory.setColor(rs.getString("color"));
                newwarehouseInventory.setSize(rs.getString("size"));
                newwarehouseInventory.setDateUpdated(rs.getDate("dateUpdated"));
                newwarehouseInventory.setQty(rs.getInt("qty"));

                warehouseInventory.add(newwarehouseInventory);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return warehouseInventory;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    

