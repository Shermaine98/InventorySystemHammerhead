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

public class DeliveryReceipt {
    private int DeliveryReceiptNumber;
    private int poNumber;
    private int checkedBy;
    private int approvedBy;
    private java.sql.Date receivedDate;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * @return the DeliveryReceiptNumber
     */
    public int getDeliveryReceiptNumber() {
        return DeliveryReceiptNumber;
    }

    /**
     * @param DeliveryReceiptNumber the DeliveryReceiptNumber to set
     */
    public void setDeliveryReceiptNumber(int DeliveryReceiptNumber) {
        this.DeliveryReceiptNumber = DeliveryReceiptNumber;
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
     * @return the receivedDate
     */
    public java.sql.Date getReceivedDate() {
        return receivedDate;
    }

    /**
     * @param receivedDate the receivedDate to set
     */
    public void setReceivedDate(java.sql.Date receivedDate) {
        this.receivedDate = receivedDate;
    }
    
     public void setReceivedDate() throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date receivedDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date receivedDate1 = formatter.parse(df.format(receivedDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(receivedDate1.getTime());
        this.receivedDate = sqlreceivedDate1;
    }
    
     
}
