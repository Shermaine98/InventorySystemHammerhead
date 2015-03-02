package Model;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class Product {

    private int productionNumber;
    private String sex;
    private String ItemDescription;
    private String ageGroup;
    private String color;
    private String size;
    private double UnitPrice;

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
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
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
     * @return the ageGroup
     */
    public String getAgeGroup() {
        return ageGroup;
    }

    /**
     * @param ageGroup the ageGroup to set
     */
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the UnitPrice
     */
    public double getUnitPrice() {
        return UnitPrice;
    }

    /**
     * @param UnitPrice the UnitPrice to set
     */
    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }
}
