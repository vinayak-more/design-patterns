/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.intefaces;

public interface HotelConnector {
    
    public void setCredentials(Credentials credentials);

    public void search();

    public void getHotelDetails();

    public void getHotelRooms();

    public void reserve();

    public void confirm();

    public void cancel();
}
