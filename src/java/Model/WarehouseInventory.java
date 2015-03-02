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

public class WarehouseInventory {
    private int productionNumber;
    private int qty;
    private String sex;
    private String itemDescription;
    private String ageGroup;
    private String Color;
    private String size;
    private java.sql.Date dateUpdated;
    
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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
     * @return the Color
     */
    public String getColor() {
        return Color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(String Color) {
        this.Color = Color;
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
     * @return the dateUpdated
     */
    public java.sql.Date getDateUpdated() {
        return dateUpdated;
    }

    
    public void setDateUpdated() throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date dateUpdated0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateUpdated1 = formatter.parse(df.format(dateUpdated0));
        java.sql.Date sqlorderdate11 = new java.sql.Date(dateUpdated1.getTime());
        this.dateUpdated = sqlorderdate11;
    }
    /**
     * @param dateUpdated the dateUpdated to set
     */
    public void setDateUpdated(java.sql.Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
    
}
