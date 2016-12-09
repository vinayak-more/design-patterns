/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.intefaces.impl;

import main.java.connector.intefaces.Credentials;
import main.java.connector.intefaces.HotelConnector;

public class TBOHotelConnector implements HotelConnector {

    @Override
    public void search() {
        System.out.println("TBOHotelConnector.search()");
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
