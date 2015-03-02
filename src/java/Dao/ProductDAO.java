package Dao;

import Model.Product;
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


public class ProductDAO {

    public boolean EncodeProduct(Product newProduct) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into product(productionNumber,sex,itemDescription,ageGroup,color,size,unitPrice) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newProduct.getProductionNumber());
            pstmt.setString(2, newProduct.getSex());
            pstmt.setString(3, newProduct.getItemDescription());
            pstmt.setString(4, newProduct.getAgeGroup());
            pstmt.setString(5, newProduct.getColor());
            pstmt.setString(6, newProduct.getSize());
            pstmt.setDouble(7, newProduct.getUnitPrice());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Product> GetAllProductList() {
        ArrayList<Product> Product = new ArrayList<Product>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product newProduct = new Product();
                newProduct.setProductionNumber(rs.getInt("productionNumber"));
                newProduct.setSex(rs.getString("sex"));
                newProduct.setItemDescription(rs.getString("itemDescription"));
                newProduct.setAgeGroup(rs.getString("ageGroup"));
                newProduct.setColor(rs.getString("color"));
                newProduct.setSize(rs.getString("size"));
                newProduct.setUnitPrice(rs.getDouble("unitPrice"));

                Product.add(newProduct);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return Product;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
