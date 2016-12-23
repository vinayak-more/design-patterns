/**
 * @author Vinayak More
 *
 * @date 23-Dec-2016
 */
package main.java.connector.intefaces.impl.tg;

import main.java.Hotel;
import main.java.connector.intefaces.ConnectorConstants;
import main.java.connector.intefaces.impl.tg.search.TGHotel;

public class TGHotelAdapter extends Hotel {

    private TGHotel hotel;

    public TGHotelAdapter(TGHotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String getName() {
        return hotel.getHotelName();
    }

    @Override
    public String getAddress() {
        return hotel.getHotelDetails().getAddress();
    }

    @Override
    public String getRating() {
        return hotel.getHotelDetails().getHotelRatting();
    }

    @Override
    public long getPrice() {
        return hotel.getMinprice();
    }

    @Override
    public String getConnector() {
        return ConnectorConstants.TG_HOTEL;
    }

}
