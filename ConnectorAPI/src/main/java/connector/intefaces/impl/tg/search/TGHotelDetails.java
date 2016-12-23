/**
 * @author Vinayak More
 *
 * @date 14-Dec-2016
 */
package main.java.connector.intefaces.impl.tg.search;

public class TGHotelDetails {
    String address;
    String hotelRatting;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param address
     */
    public TGHotelDetails(String address) {
        super();
        this.address = address;
    }

    /**
     * @param address
     * @param hotelRatting
     */
    public TGHotelDetails(String address, String hotelRatting) {
        super();
        this.address = address;
        this.hotelRatting = hotelRatting;
    }

    public String getHotelRatting() {
        return hotelRatting;
    }

    public void setHotelRatting(String hotelRatting) {
        this.hotelRatting = hotelRatting;
    }

}
