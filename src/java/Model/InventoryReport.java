package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class InventoryReport {
    
    private int promo;
    private int remainingQuantity;
    private int soldQty;
    private int pulledOutQty;
    private int ProductionNumber;
    private String outlet;
    private String sex;
    private String size;
    private String itemDescription;
    private String ageGroup;
    private String color;
    private java.sql.Date dateMade;
    
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
     * @return the remainingQuantity
     */
    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    /**
     * @param remainingQuantity the remainingQuantity to set
     */
    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    /**
     * @return the soldQty
     */
    public int getSoldQty() {
        return soldQty;
    }

    /**
     * @param soldQty the soldQty to set
     */
    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    /**
     * @return the pulledOutQty
     */
    public int getPulledOutQty() {
        return pulledOutQty;
    }

    /**
     * @param pulledOutQty the pulledOutQty to set
     */
    public void setPulledOutQty(int pulledOutQty) {
        this.pulledOutQty = pulledOutQty;
    }

    /**
     * @return the ProductionNumber
     */
    public int getProductionNumber() {
        return ProductionNumber;
    }

    /**
     * @param ProductionNumber the ProductionNumber to set
     */
    public void setProductionNumber(int ProductionNumber) {
        this.ProductionNumber = ProductionNumber;
    }

    /**
     * @return the outlet
     */
    public String getOutlet() {
        return outlet;
    }

    /**
     * @param outlet the outlet to set
     */
    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
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
     * @return the itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * @param itemDescription the itemDescription to set
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * @return the ageGroup
     */
    public String getAgeGroup() {
        return ageGroup;
    }

    /**
     * @param ageGroup the ageGroup to set
     */
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
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
     * @return the dateMade
     */
    public java.sql.Date getDateMade() {
        return dateMade;
    }
    
     public void setDateMade() throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date dateMade0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateMade1 = formatter.parse(df.format(dateMade0));
        java.sql.Date sqlorderdate11 = new java.sql.Date(dateMade1.getTime());
        this.dateMade = sqlorderdate11;
    }

    /**
     * @param dateMade the dateMade to set
     */
    public void setDateMade(java.sql.Date dateMade) {
        this.dateMade = dateMade;
    }
            
}
