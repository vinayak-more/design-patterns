/**
 * @author Vinayak More
 *
 * @date 23-Dec-2016
 */
package main.java.connector.intefaces.impl.tbo;

import main.java.Hotel;
import main.java.connector.intefaces.ConnectorConstants;
import main.java.connector.intefaces.impl.tbo.search.TBOHotel;

public class TBOHotelAdapter extends Hotel {


    private TBOHotel hotel;

    public TBOHotelAdapter(TBOHotel hotel) {
        this.hotel = hotel;
    }
    @Override
    public String getName() {
        return hotel.getHotelName();
    }
    
    @Override
    public String getAddress() {
        return hotel.getHotelAddress();
    }
    
    @Override
    public String getRating() {
        return hotel.getStarRating();
    }
    
    @Override
    public long getPrice() {
        return hotel.getMinprice();
    }
    
    @Override
    public String getConnector() {
        return ConnectorConstants.TBO_HOTEL;
    }

}
