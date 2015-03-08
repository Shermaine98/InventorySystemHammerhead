
package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class PurchaseOrder {
          
    private int PoNumber;
    private int qty;
    private String type;
    private int preparedBy;
    private int approvedBy;
    private String ItemDescription;
    private String unitMeasurement;
    private Double Unitprice;
    private Double vat;
    private java.sql.Date dateMade;
    private String Supplier;
    private java.sql.Date deliverySchedule;
    
   DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @return the Numeric
     */
    public int getPoNumber() {
        return PoNumber;
    }

    /**
     * @param Numeric the Numeric to set
     */
    public void setPoNumber(int PoNumber) {
        this.PoNumber = PoNumber;
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
     * @return the preparedBy
     */
    public int getPreparedBy() {
        return preparedBy;
    }

    /**
     * @param preparedBy the preparedBy to set
     */
    public void setPreparedBy(int preparedBy) {
        this.preparedBy = preparedBy;
    }

    /**
     * @return the approvedBy
     */
    public int getApprovedBy() {
        return approvedBy;
    }

    /**
     * @param approvedBy the approvedBy to set
     */
    public void setApprovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }

    /**
     * @return the ItemDescription
     */
    public String getItemDescription() {
        return ItemDescription;
    }

    /**
     * @param ItemDescription the ItemDescription to set
     */
    public void setItemDescription(String ItemDescription) {
        this.ItemDescription = ItemDescription;
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
     * @return the Unitprice
     */
    public Double getUnitprice() {
        return Unitprice;
    }

    /**
     * @param Unitprice the Unitprice to set
     */
    public void setUnitprice(Double Unitprice) {
        this.Unitprice = Unitprice;
    }

    /**
     * @return the vat
     */
    public Double getVat() {
        return vat;
    }

    /**
     * @param vat the vat to set
     */
    public void setVat(Double vat) {
        this.vat = vat;
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

    /**
     * @return the Supplier
     */
    public String getSupplier() {
        return Supplier;
    }

    /**
     * @param Supplier the Supplier to set
     */
    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    /**
     * @return the deliverySchedule
     */
    public java.sql.Date getDeliverySchedule() {
        return deliverySchedule;
    }

    /**
     * @param deliverySchedule the deliverySchedule to set
     */
   
     public void setDeliverySchedule(java.sql.Date deliverySchedule) {
        this.deliverySchedule = deliverySchedule;
    }
    
    public void setDeliverySchedule(String deliverySchedule) throws ParseException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date deliverySchedule1 = formatter.parse(df.format(deliverySchedule));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(deliverySchedule1.getTime());
        this.deliverySchedule = sqlreceivedDate1;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
  
       
}
