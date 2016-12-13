/**
 * @author Vinayak More
 *
 * @date 10-Dec-2016
 */
package main.java.connector.intefaces.impl;

import main.java.connector.intefaces.Credentials;
import main.java.connector.intefaces.HotelConnector;

public class TBOHotelIntConnector implements HotelConnector {



    @Override
    public void setCredentials(Credentials credentials) {
        System.out.println("TBOHotelIntConnector.setCredentials()");
    }

    @Override
    public void search() {
        System.out.println("TBOHotelIntConnector.search()");
    }

    @Override
    public void getHotelDetails() {
        System.out.println("TBOHotelIntConnector.getHotelDetails()");
    }

    @Override
    public void getHotelRooms() {
        System.out.println("TBOHotelIntConnector.getHotelRooms()");
    }

    @Override
    public void reserve() {
        System.out.println("TBOHotelIntConnector.reserve()");
    }

    @Override
    public void confirm() {
        System.out.println("TBOHotelIntConnector.confirm()");
    }

    @Override
    public void cancel() {
        System.out.println("TBOHotelIntConnector.cancel()");
    }

}
