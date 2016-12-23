/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.intefaces.impl.rezlive;

import java.util.List;

import main.java.Hotel;
import main.java.connector.intefaces.Credentials;
import main.java.connector.intefaces.HotelConnector;
import main.java.connector.intefaces.impl.rezlive.search.RezliveHotel;
import main.java.connector.service.impl.WebService;

public class RezliveHotelConnector extends HotelConnector {

    @Override
    public void setCredentials(Credentials credentials) {
        System.out.println("RezliveHotelConnector.setCredentials()");
    }

    @Override
    public List<Hotel> search() {
        System.out.println("RezliveHotelConnector.search()");
        List<RezliveHotel> hotelList=WebService.getInstance().getRezliveHotels();
        return RezliveHotelProcessor.processResponse(hotelList);
    }

    @Override
    public void getHotelDetails() {
        System.out.println("RezliveHotelConnector.getHotelDetails()");
    }

    @Override
    public void reserve() {
        System.out.println("RezliveHotelConnector.reserve()");
    }

    @Override
    public void confirm() {
        System.out.println("RezliveHotelConnector.confirm()");
    }

    @Override
    public void cancel() {
        System.out.println("RezliveHotelConnector.cancel()");
    }
}
