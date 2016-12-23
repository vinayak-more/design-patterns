/**
 * @author Vinayak More
 *
 * @date 14-Dec-2016
 */
package main.java.connector.intefaces.impl.tg.search;

public class TGHotel {
    String hotelName;
    String hotelCode;
    long Minprice;
    TGHotelDetails hotelDetails;
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
    public long getMinprice() {
        return Minprice;
    }
    public void setMinprice(long minprice) {
        Minprice = minprice;
    }
    public TGHotelDetails getHotelDetails() {
        return hotelDetails;
    }
    public void setHotelDetails(TGHotelDetails hotelDetails) {
        this.hotelDetails = hotelDetails;
    }
    /**
     * @param hotelName
     * @param hotelCode
     * @param minprice
     * @param hotelDetails
     */
    public TGHotel(String hotelName, String hotelCode, long minprice, TGHotelDetails hotelDetails) {
        super();
        this.hotelName = hotelName;
        this.hotelCode = hotelCode;
        Minprice = minprice;
        this.hotelDetails = hotelDetails;
    }
    
}
