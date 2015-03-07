/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.InventoryReport;
import Model.PickingForm;
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
 * @author Marielle
 */
public class PickingFormDAO {
    
    public boolean EncodepickingForm(PickingForm newPickingForm) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into picking_form (promo, "
                    + "dateMade, productID, size, color, madeBy, requestedQty) "
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newPickingForm.getPromo());
            pstmt.setDate(3, newPickingForm.getDateMade());
            pstmt.setString(4, newPickingForm.getSize());
            pstmt.setString(5, newPickingForm.getColor());
            pstmt.setInt(6, newPickingForm.getMadeBy());
            pstmt.setInt(7, newPickingForm.getRequestedQty());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PickingFormDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<PickingForm> GetAllPickingForm() throws ParseException {
        ArrayList<PickingForm> PickingForm = new ArrayList<PickingForm>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM picking_form");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PickingForm newPickingForm = new PickingForm();
                newPickingForm.setPromo(rs.getInt("promo"));
                newPickingForm.setDateMade();
                newPickingForm.setProductID(rs.getInt("productID"));
                newPickingForm.setSize(rs.getString("size"));
                newPickingForm.setColor(rs.getString("color"));
                newPickingForm.setMadeBy(rs.getInt("madeBy"));
                newPickingForm.setRequestedQty(rs.getInt("requestedQty"));

                PickingForm.add(newPickingForm);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return PickingForm;
        } catch (SQLException ex) {
            Logger.getLogger(PickingFormDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
