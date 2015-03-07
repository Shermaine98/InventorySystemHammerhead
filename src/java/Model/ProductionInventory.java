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

    private int productionNumber;
    private String category;
    private int drNumber;
    private java.sql.Date dateUpdated;
    private int qty;
    private String unitMeasurement;
    private boolean approval;
    private String note;

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
     * @return the dateUpdated
     */
    public java.sql.Date getDateUpdated() {
        return dateUpdated;
    }

    /**
     * @param dateUpdated the dateUpdated to set
     */
    public void setDateUpdated() throws ParseException{
        @SuppressWarnings("deprecation")
        java.util.Date updatedDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date updatedDate1 = formatter.parse(df.format(updatedDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(updatedDate1.getTime());
        this.dateUpdated = sqlreceivedDate1;
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
     * @return the approval
     */
    public boolean isApproval() {
        return approval;
    }

    /**
     * @param approval the approval to set
     */
    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    
}
