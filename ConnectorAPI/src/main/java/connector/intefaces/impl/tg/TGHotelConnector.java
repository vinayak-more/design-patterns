/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.intefaces.impl.tg;

import java.util.List;

import main.java.Hotel;
import main.java.connector.intefaces.Credentials;
import main.java.connector.intefaces.HotelConnector;
import main.java.connector.intefaces.impl.tg.search.TGHotel;
import main.java.connector.service.impl.WebService;

public class TGHotelConnector extends HotelConnector {

    @Override
    public List<Hotel> search() {
        System.out.println("TGHotelConnector.search()");
        List<TGHotel> tgHotels = WebService.getInstance().getTgHotels();
        return TGHotelProcessor.processResponse(tgHotels);
    }

    @Override
    public void getHotelDetails() {
        System.out.println("TGHotelConnector.getHotelDetails()");
    }

    @Override
    public void reserve() {
        System.out.println("TGHotelConnector.reserve()");
    }

    @Override
    public void confirm() {
        System.out.println("TGHotelConnector.confirm()");
    }

    @Override
    public void cancel() {
        System.out.println("TGHotelConnector.cancel()");
    }


    @Override
    public void setCredentials(Credentials credentials) {
        System.out.println("TGHotelConnector.setCredentials()");
    }

}
