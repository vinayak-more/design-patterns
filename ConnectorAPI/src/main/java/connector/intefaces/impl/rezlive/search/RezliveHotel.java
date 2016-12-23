/**
 * @author Vinayak More
 *
 * @date 14-Dec-2016
 */
package main.java.connector.intefaces.impl.rezlive.search;

public class RezliveHotel {

    /**
     * @param hotelName
     * @param hotelCode
     * @param starRating
     * @param minprice
     */
    public RezliveHotel(String hotelName, String hotelCode, String starRating, long minprice) {
        super();
        this.hotelName = hotelName;
        this.hotelCode = hotelCode;
        this.starRating = starRating;
        Minprice = minprice;
    }

    String hotelName;
    String hotelCode;
    String starRating;
    long Minprice;

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



}
