/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.intefaces.impl;

import main.java.connector.intefaces.Credentials;
import main.java.connector.intefaces.HotelConnector;

public class RezliveHotelConnector implements HotelConnector {

    @Override
    public void setCredentials(Credentials credentials) {
        System.out.println("RezliveHotelConnector.setCredentials()");
    }

    @Override
    public void search() {
        System.out.println("RezliveHotelConnector.search()");
    }

    @Override
    public void getHotelDetails() {
        System.out.println("RezliveHotelConnector.getHotelDetails()");
    }

    @Override
    public void getHotelRooms() {
        System.out.println("RezliveHotelConnector.getHotelRooms()");
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
