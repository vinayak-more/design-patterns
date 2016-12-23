/**
 * @author Vinayak More
 *
 * @date 14-Dec-2016
 */
package main.java.connector.intefaces.impl.tbo.search;

public class TBOHotel {
    String hotelName;
    String hotelCode;
    String starRating;
    long Minprice;
    String hotelAddress;
    
    
    /**
     * @param hotelName
     * @param hotelCode
     * @param starRating
     * @param minprice
     * @param hotelAddress
     */
    public TBOHotel(String hotelName, String hotelCode, String starRating, long minprice, String hotelAddress) {
        super();
        this.hotelName = hotelName;
        this.hotelCode = hotelCode;
        this.starRating = starRating;
        Minprice = minprice;
        this.hotelAddress = hotelAddress;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public String getHotelCode() {
        return hotelCode;
    }
    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }
    public String getStarRating() {
        return starRating;
    }
    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }
    public long getMinprice() {
        return Minprice;
    }
    public void setMinprice(long minprice) {
        Minprice = minprice;
    }
    public String getHotelAddress() {
        return hotelAddress;
    }
    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }
}
