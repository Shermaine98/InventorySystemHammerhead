package Model;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class ConsumptionReportToAccessoriesInventory {

    private int productionNumber;
    private int consumption;
    private String category;
    private String accessoryDescription;
    private String unit;

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
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
