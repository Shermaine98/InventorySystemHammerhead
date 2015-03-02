package Model;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class CuttingReport {
    private int cuttingMaster;
    private int stockNumber;
    private String category;
    private int deliveryReceiptNumber;
    private int rawQty;
    private int finalQty;

    /**
     * @return the cuttingMaster
     */
    public int getCuttingMaster() {
        return cuttingMaster;
    }

    /**
     * @param cuttingMaster the cuttingMaster to set
     */
    public void setCuttingMaster(int cuttingMaster) {
        this.cuttingMaster = cuttingMaster;
    }

    /**
     * @return the stockNumber
     */
    public int getStockNumber() {
        return stockNumber;
    }

    /**
     * @param stockNumber the stockNumber to set
     */
    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
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
     * @return the rawQty
     */
    public int getRawQty() {
        return rawQty;
    }

    /**
     * @param rawQty the rawQty to set
     */
    public void setRawQty(int rawQty) {
        this.rawQty = rawQty;
    }

    /**
     * @return the finalQty
     */
    public int getFinalQty() {
        return finalQty;
    }

    /**
     * @param finalQty the finalQty to set
     */
    public void setFinalQty(int finalQty) {
        this.finalQty = finalQty;
    }
}
