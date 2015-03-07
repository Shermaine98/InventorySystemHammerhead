package Dao;


import Model.ProductionInventory;
import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
                String query = "insert into production_inventory(productionNumber, category, drNumber, DateUpdated,"
                        + "qty,unitMeasurement,approval,note) values (?,?,?,?,?,?,?,?) ";
                PreparedStatement pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, newProductionInventory.getProductionNumber());
                pstmt.setString(2, newProductionInventory.getCategory());
                pstmt.setInt(3, newProductionInventory.getDrNumber());
                pstmt.setDate(4, newProductionInventory.getDateUpdated());
                pstmt.setInt(5, newProductionInventory.getQty());
                pstmt.setString(6, newProductionInventory.getUnitMeasurement());
                pstmt.setBoolean(7, newProductionInventory.isApproval());
                pstmt.setString(8, newProductionInventory.getNote());
               
               
                int rows = pstmt.executeUpdate();
                conn.close();
                return rows == 1;
            } catch (SQLException ex) {
                Logger.getLogger(ProductionInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public ArrayList<ProductionInventory> MonitorProductionInventory() throws ParseException{       
            
            ArrayList <ProductionInventory> ProductionInventory = new ArrayList<ProductionInventory>();
            
            try {
                DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
                Connection conn = myFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from production_inventory");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    ProductionInventory temp = new ProductionInventory();
                    temp.setProductionNumber(rs.getInt("productionNumber"));
                    temp.setCategory(rs.getString("category"));
                    temp.setDrNumber(rs.getInt("drNumber"));
                    temp.setDateUpdated();
                    temp.setQty(rs.getInt("qty"));
                    temp.setUnitMeasurement(rs.getString("unitMeasurement"));
                    temp.setApproval(rs.getBoolean("approval"));
                    temp.setNote(rs.getString("note"));
                    
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
