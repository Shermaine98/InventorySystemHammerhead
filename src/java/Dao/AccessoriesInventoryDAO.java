package Dao;

import Model.AccessoriesInventory;
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

public class AccessoriesInventoryDAO {
    
     public boolean EncodeAccessoriesInventory(AccessoriesInventory newAccessoriesInventory){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into accessories_inventory"
                        + "(category,accessoryDescription,drNumber,dateUpdated,qty,unitMeasurement,approval,note) "
                        + "values (?,?,?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setString(1, newAccessoriesInventory.getCategory());
                pstmt.setString(2, newAccessoriesInventory.getAccessoryDescription());
                pstmt.setInt(3, newAccessoriesInventory.getDeliveryReceiptNumber());
                pstmt.setDate(4, newAccessoriesInventory.getDateUpdated());
                pstmt.setInt(5, newAccessoriesInventory.getQty());
                pstmt.setString(6, newAccessoriesInventory.getUnitMeasurement());
                pstmt.setBoolean(7, newAccessoriesInventory.isApproval());
                pstmt.setString(8, newAccessoriesInventory.getNote());
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(AccessoriesInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<AccessoriesInventory> MonitorAccessoriesInventory(){       
            
            ArrayList <AccessoriesInventory> AccessoriesInventory = new ArrayList<AccessoriesInventory>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from accessories_inventory");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    AccessoriesInventory temp = new AccessoriesInventory();
                    temp.setCategory(rs.getString("category"));
                    temp.setAccessoryDescription(rs.getString("accessoryDescription"));
                    temp.setDeliveryReceiptNumber(rs.getInt("drNumber"));
                    temp.setDateUpdated(rs.getDate("dateUpdated"));
                    temp.setQty(rs.getInt("qty"));
                    temp.setUnitMeasurement(rs.getString("unitMeasurement"));
                    temp.setApproval(rs.getBoolean("approval"));
                    temp.setNote(rs.getString("note"));
                
                    AccessoriesInventory.add(temp);
                }
                pstmt.close();
                conn.close();

                return AccessoriesInventory;
            } catch (SQLException ex) {
                Logger.getLogger(AccessoriesInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
