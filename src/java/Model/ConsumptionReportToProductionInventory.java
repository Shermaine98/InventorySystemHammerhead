package Model;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class ConsumptionReportToProductionInventory {

    private int productionNumber;
    private int stockNumber;
    private int consumption;
    private String category;
    private String unitMeasurement;

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
     * @return the consumption
     */
    public int getConsumption() {
        return consumption;
    }

    /**
     * @param consumption the consumption to set
     */
    public void setConsumption(int consumption) {
        this.consumption = consumption;
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
}
