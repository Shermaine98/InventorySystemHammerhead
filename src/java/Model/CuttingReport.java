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
    private int productionNumber;
    private String category;
    private int drNumber;
    private int cuttingMaster;
    private int rawQty;
    private int calculatedQty;
    private int actualQty;
    private String comment;

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
     * @return the calculatedQty
     */
    public int getCalculatedQty() {
        return calculatedQty;
    }

    /**
     * @param calculatedQty the calculatedQty to set
     */
    public void setCalculatedQty(int calculatedQty) {
        this.calculatedQty = calculatedQty;
    }

    /**
     * @return the actualQty
     */
    public int getActualQty() {
        return actualQty;
    }

    /**
     * @param actualQty the actualQty to set
     */
    public void setActualQty(int actualQty) {
        this.actualQty = actualQty;
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
