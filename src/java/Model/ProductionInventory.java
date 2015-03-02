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
public class ProductionInventory {

    private int StockNumber;
    private int deliveryReceiptNumber;
    private int qty;
    private String category;
    private String unitMeasurement;
    private java.sql.Date DateUpdated;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @return the StockNumber
     */
    public int getStockNumber() {
        return StockNumber;
    }

    /**
     * @param StockNumber the StockNumber to set
     */
    public void setStockNumber(int StockNumber) {
        this.StockNumber = StockNumber;
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
}
