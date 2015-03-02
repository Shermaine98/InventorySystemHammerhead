package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConsumptionReport {

    private int productionNumber;
    private int prodQty;
    private int preparedBy;
    private int approvedBy;
    private java.sql.Date dateMade;

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
     * @return the prodQty
     */
    public int getProdQty() {
        return prodQty;
    }

    /**
     * @param prodQty the prodQty to set
     */
    public void setProdQty(int prodQty) {
        this.prodQty = prodQty;
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
     * @return the DateUpdated
     */
    public java.sql.Date getdateMade() {
        return dateMade;
    }

    /**
     * @param DateUpdated the DateUpdated to set
     */
    public void setdateMade(java.sql.Date dateMade) {
        this.dateMade = dateMade;
    }
    
    public void setDateMade() throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date dateMade0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateMade1 = formatter.parse(df.format(dateMade0));
        java.sql.Date sqlorderdate11 = new java.sql.Date(dateMade1.getTime());
        this.dateMade = sqlorderdate11;
    }
    
}
