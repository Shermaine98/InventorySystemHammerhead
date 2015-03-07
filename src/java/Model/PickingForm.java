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
public class PickingForm {
    private int promo;
    private java.sql.Date dateMade;
    private int productID;
    private String size;
    private String color;
    private int madeBy;
    private int requestedQty;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * @return the promo
     */
    public int getPromo() {
        return promo;
    }

    /**
     * @param promo the promo to set
     */
    public void setPromo(int promo) {
        this.promo = promo;
    }

    /**
     * @return the dateMade
     */
    public java.sql.Date getDateMade() {
        return dateMade;
    }

    /**
     * @param dateMade the dateMade to set
     */
    public void setDateMade() throws ParseException{
        @SuppressWarnings("deprecation")
        java.util.Date madeDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date madeDate1 = formatter.parse(df.format(madeDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(madeDate1.getTime());
        this.dateMade = sqlreceivedDate1;
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
     * @return the madeBy
     */
    public int getMadeBy() {
        return madeBy;
    }

    /**
     * @param madeBy the madeBy to set
     */
    public void setMadeBy(int madeBy) {
        this.madeBy = madeBy;
    }

    /**
     * @return the requestedQty
     */
    public int getRequestedQty() {
        return requestedQty;
    }

    /**
     * @param requestedQty the requestedQty to set
     */
    public void setRequestedQty(int requestedQty) {
        this.requestedQty = requestedQty;
    }
    
}
