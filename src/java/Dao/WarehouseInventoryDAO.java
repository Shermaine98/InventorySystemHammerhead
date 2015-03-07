
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
            String query = "insert into warehouse_inventory"
                    + "(drNumber,productionNumber,productID,size,dateUpdated,qty,approval,note) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, newWarehouseInventory.getDrNumber());
            pstmt.setInt(2, newWarehouseInventory.getProductionNumber());
            pstmt.setInt(3, newWarehouseInventory.getProductID());
            pstmt.setString(4, newWarehouseInventory.getSize());
            pstmt.setDate(5, newWarehouseInventory.getDateUpdated());
            pstmt.setInt(6, newWarehouseInventory.getQty());
            pstmt.setBoolean(7, newWarehouseInventory.isApproval());
            pstmt.setString(8, newWarehouseInventory.getNote());
            

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                WarehouseInventory newWarehouseInventory = new WarehouseInventory();
                
                newWarehouseInventory.setDrNumber(rs.getInt("drNumber"));
                newWarehouseInventory.setProductionNumber(rs.getInt("productionNumber"));
                newWarehouseInventory.setProductID(rs.getInt("productID"));
                newWarehouseInventory.setSize(rs.getString("size"));
                newWarehouseInventory.setDateUpdated(rs.getDate("dateUpdated"));
                newWarehouseInventory.setQty(rs.getInt("qty"));
                newWarehouseInventory.setApproval(rs.getBoolean("approval"));
                newWarehouseInventory.setNote(rs.getString("note"));
                
                warehouseInventory.add(newWarehouseInventory);

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
    

