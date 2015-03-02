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

public class DeliverySchedule {
    private int deliveryOrderNumber;
    private int preparedBy;
    private int driver;
    private java.sql.Date date;
    
     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @return the deliveryOrderNumber
     */
    public int getDeliveryOrderNumber() {
        return deliveryOrderNumber;
    }

    /**
     * @param deliveryOrderNumber the deliveryOrderNumber to set
     */
    public void setDeliveryOrderNumber(int deliveryOrderNumber) {
        this.deliveryOrderNumber = deliveryOrderNumber;
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
     * @return the driver
     */
    public int getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(int driver) {
        this.driver = driver;
    }

    /**
     * @return the date
     */
    public java.sql.Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(java.sql.Date date) {
        this.date = date;
    }
    
    public void setDate() throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date date0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = formatter.parse(df.format(date0));
        java.sql.Date sqlordate11 = new java.sql.Date(date1.getTime());
        this.date = sqlordate11;
    }
    
   
}
