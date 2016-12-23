/**
 * @author Vinayak More
 *
 * @date 22-Dec-2016
 */
package main.java.connector.intefaces.impl.rezlive.search;

import main.java.Hotel;
import main.java.connector.intefaces.ConnectorConstants;

public class RezliveHotelAdapter extends Hotel {

    RezliveHotel hotel;

    public RezliveHotelAdapter(RezliveHotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String getName() {
        return hotel.hotelName;
    }

    @Override
    public String getAddress() {
        return "NA";
    }

    @Override
    public String getRating() {
        return hotel.starRating;
    }

    @Override
    public long getPrice() {
        return hotel.Minprice;
    }

    @Override
    public String getConnector() {
        return ConnectorConstants.REZLIVE_HOTEL;
    }
    
    
}
