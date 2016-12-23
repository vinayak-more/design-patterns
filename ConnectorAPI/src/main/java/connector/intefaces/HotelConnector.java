/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.intefaces;

import java.util.List;

import main.java.Hotel;

public abstract class HotelConnector {

    public abstract void setCredentials(Credentials credentials);

    public abstract List<Hotel> search();

    public abstract void getHotelDetails();

    public void getHotelRooms() {
        System.out.println("HotelConnector.getHotelRooms() Default Behaviour");
    }

    public abstract void reserve();

    public abstract void confirm();

    public abstract void cancel();
}
