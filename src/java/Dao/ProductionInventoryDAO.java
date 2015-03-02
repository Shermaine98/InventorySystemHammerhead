package Dao;


import Model.ProductionInventory;
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

public class ProductionInventoryDAO {
     public boolean EncodeProductionInventory(ProductionInventory newProductionInventory){
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                String query = "insert into production_inventory(DateUpdated,qty,unitMeasurement,deliveryReceiptNumber,stockNumber,category) values (?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);
                
                pstmt.setDate(1, newProductionInventory.getDateUpdated());
                pstmt.setInt(2, newProductionInventory.getQty());
                pstmt.setString(3, newProductionInventory.getUnitMeasurement());
                pstmt.setInt(4, newProductionInventory.getDeliveryReceiptNumber());
                pstmt.setInt(5, newProductionInventory.getStockNumber());
                 pstmt.setString(6, newProductionInventory.getCategory());
               
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(ProductionInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<ProductionInventory> MonitorProductionInventory(){       
            
            ArrayList <ProductionInventory> ProductionInventory = new ArrayList<ProductionInventory>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from production_inventory");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    ProductionInventory temp = new ProductionInventory();
                    temp.setDateUpdated(rs.getDate("DateUpdated"));
                    temp.setQty(rs.getInt("qty"));
                    temp.setUnitMeasurement(rs.getString("unitMeasurement"));
                    temp.setDeliveryReceiptNumber(rs.getInt("deliveryReceiptNumber"));
                    temp.setStockNumber(rs.getInt("stockNumber"));
                    temp.setCategory(rs.getString("category"));
                    
                    ProductionInventory.add(temp);
                }
                pstmt.close();
                conn.close();

                return ProductionInventory;
            } catch (SQLException ex) {
                Logger.getLogger(ProductionInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                return null;
	}
}
