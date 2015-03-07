/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.SupplierDeliveryReceipt;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class SupplierDeliveryReceiptDAO {

    public boolean EncodeDeliveryReceipt(SupplierDeliveryReceipt newSupplierDeliveryReceipt) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into supplier_delivery_receipt"
                    + "(poNumber,itemDescription,dateReceived,checkedBy,receivedBy,status,qty,comment) values (?,?,?,?,?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSupplierDeliveryReceipt.getPoNumber());
            pstmt.setString(2, newSupplierDeliveryReceipt.getItemDescription());
            pstmt.setDate(3, newSupplierDeliveryReceipt.getReceivedDate());
            pstmt.setInt(4, newSupplierDeliveryReceipt.getCheckedBy());
            pstmt.setInt(5, newSupplierDeliveryReceipt.getreceivedBy());
            pstmt.setString(6, newSupplierDeliveryReceipt.getStatus());
            pstmt.setInt(7, newSupplierDeliveryReceipt.getQty());
            pstmt.setString(8, newSupplierDeliveryReceipt.getComment());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SupplierDeliveryReceipt> GetDeliveryReceiptList() {

        ArrayList<SupplierDeliveryReceipt> DeliveryReceipt = new ArrayList<SupplierDeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from supplier_delivery_receipt");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                SupplierDeliveryReceipt temp = new SupplierDeliveryReceipt();
                temp.setDeliveryReceiptNumber(rs.getInt("deliveryReceiptNumber"));
                temp.setPoNumber(rs.getInt("poNumber"));
                temp.setPoNumber(rs.getInt("itemDescription"));
                temp.setReceivedDate(rs.getDate("dateReceived"));
                temp.setCheckedBy(rs.getInt("checkedBy"));
                temp.setreceivedBy(rs.getInt("receivedBy"));
                temp.setCheckedBy(rs.getInt("status"));
                temp.setQty(rs.getInt("qty"));
                temp.setCheckedBy(rs.getInt("comment"));

                DeliveryReceipt.add(temp);
            }
            pstmt.close();
            conn.close();

            return DeliveryReceipt;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
