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

public class SupplierDeliveryReceipt {
    private int DeliveryReceiptNumber;
    private int poNumber;
    private String itemDescription;
    private int checkedBy;
    private int receivedBy;
    private String status;
    private int qty;
    private java.sql.Date receivedDate;
    private String comment;

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
    public int getreceivedBy() {
        return receivedBy;
    }

    /**
     * @param receivedBy the approvedBy to set
     */
    public void setreceivedBy(int receivedBy) {
        this.receivedBy = receivedBy;
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
