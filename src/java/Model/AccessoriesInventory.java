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
public class AccessoriesInventory {

    private String category;
    private String accessoryDescription;
    private String unitMeasurement;
    private java.sql.Date DateUpdated;
    private int deliveryReceiptNumber;
    private int qty;
    
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the accessoryDescription
     */
    public String getAccessoryDescription() {
        return accessoryDescription;
    }

    /**
     * @param accessoryDescription the accessoryDescription to set
     */
    public void setAccessoryDescription(String accessoryDescription) {
        this.accessoryDescription = accessoryDescription;
    }

    /**
     * @return the unitMeasurement
     */
    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    /**
     * @param unitMeasurement the unitMeasurement to set
     */
    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    /**
     * @return the DateUpdated
     */
    public java.sql.Date getDateUpdated() {
        return DateUpdated;
    }

    /**
     * @param DateUpdated the DateUpdated to set
     */
    public void setDateUpdated(java.sql.Date DateUpdated) {
        this.DateUpdated = DateUpdated;
    }

     public void setDateUpdated() throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date DateUpdated0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date DateUpdated1 = formatter.parse(df.format(DateUpdated0));
        java.sql.Date sqlDateUpdated1 = new java.sql.Date(DateUpdated1.getTime());
        this.DateUpdated = sqlDateUpdated1;
    }
    /**
     * @return the deliveryReceiptNumber
     */
    public int getDeliveryReceiptNumber() {
        return deliveryReceiptNumber;
    }

    /**
     * @param deliveryReceiptNumber the deliveryReceiptNumber to set
     */
    public void setDeliveryReceiptNumber(int deliveryReceiptNumber) {
        this.deliveryReceiptNumber = deliveryReceiptNumber;
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

    
}
