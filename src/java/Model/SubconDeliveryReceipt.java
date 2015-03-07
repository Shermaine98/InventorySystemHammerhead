/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Marielle
 */
public class SubconDeliveryReceipt {
    private int drNumber;
    private int poNumber;
    private int productionNumber;
    private int productID;
    private String size;
    private String color;
    private java.sql.Date dateRecieved;
    private int checkedBy;
    private int receivedBy;
    private String status;
    private int qty;
    private String comment;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * @return the drNumber
     */
    public int getDrNumber() {
        return drNumber;
    }

    /**
     * @param drNumber the drNumber to set
     */
    public void setDrNumber(int drNumber) {
        this.drNumber = drNumber;
    }

    /**
     * @return the poNumber
     */
    public int getPoNumber() {
        return poNumber;
    }

    /**
     * @param poNumber the poNumber to set
     */
    public void setPoNumber(int poNumber) {
        this.poNumber = poNumber;
    }

    /**
     * @return the productionNumber
     */
    public int getProductionNumber() {
        return productionNumber;
    }

    /**
     * @param productionNumber the productionNumber to set
     */
    public void setProductionNumber(int productionNumber) {
        this.productionNumber = productionNumber;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the dateRecieved
     */
    public java.sql.Date getDateRecieved() {
        return dateRecieved;
    }

    /**
     * @param dateRecieved the dateRecieved to set
     */
    public void setDateRecieved() throws ParseException{
        @SuppressWarnings("deprecation")
        java.util.Date receivedDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date receivedDate1 = formatter.parse(df.format(receivedDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(receivedDate1.getTime());
        this.dateRecieved = sqlreceivedDate1;
    }
    
    public void setDateReceived(java.sql.Date dateReceived) {
        this.dateRecieved = dateRecieved;
    }

    /**
     * @return the checkedBy
     */
    public int getCheckedBy() {
        return checkedBy;
    }

    /**
     * @param checkedBy the checkedBy to set
     */
    public void setCheckedBy(int checkedBy) {
        this.checkedBy = checkedBy;
    }

    /**
     * @return the receivedBy
     */
    public int getReceivedBy() {
        return receivedBy;
    }

    /**
     * @param receivedBy the receivedBy to set
     */
    public void setReceivedBy(int receivedBy) {
        this.receivedBy = receivedBy;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
