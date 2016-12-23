/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.intefaces.impl.tbo;

import java.util.List;

import main.java.Hotel;
import main.java.connector.intefaces.Credentials;
import main.java.connector.intefaces.HotelConnector;
import main.java.connector.intefaces.impl.tbo.search.TBOHotel;
import main.java.connector.service.impl.WebService;

public class TBOHotelConnector extends HotelConnector {

    @Override
    public List<Hotel> search() {
        System.out.println("TBOHotelConnector.search()");
        List<TBOHotel> tboHotels = WebService.getInstance().getTboHotels();
        return TBOHotelProcessor.processResponse(tboHotels);
    }

    @Override
    public void getHotelDetails() {
        System.out.println("TBOHotelConnector.getHotelDetails()");
    }

    @Override
    public void getHotelRooms() {
        System.out.println("TBOHotelConnector.getHotelRooms()");
    }

    @Override
    public void reserve() {
        System.out.println("TBOHotelConnector.reserve()");
    }

    @Override
    public void confirm() {
        System.out.println("TBOHotelConnector.confirm()");
    }

    @Override
    public void cancel() {
        System.out.println("TBOHotelConnector.cancel()");
    }

    @Override
    public void setCredentials(Credentials credentials) {
        System.out.println("TBOHotelConnector.setCredentials()");
    }


}
