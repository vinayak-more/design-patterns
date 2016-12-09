/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.intefaces.impl;

import main.java.connector.intefaces.Credentials;
import main.java.connector.intefaces.HotelConnector;

public class TGHotelConnector implements HotelConnector {

    @Override
    public void search() {
        System.out.println("TGHotelConnector.search()");
    }

    @Override
    public void getHotelDetails() {
        System.out.println("TGHotelConnector.getHotelDetails()");
    }

    @Override
    public void getHotelRooms() {
        System.out.println("TGHotelConnector.getHotelRooms()");
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
