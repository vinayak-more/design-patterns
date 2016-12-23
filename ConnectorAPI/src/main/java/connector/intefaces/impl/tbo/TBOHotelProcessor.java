/**
 * @author Vinayak More
 *
 * @date 23-Dec-2016
 */
package main.java.connector.intefaces.impl.tbo;

import java.util.LinkedList;
import java.util.List;

import main.java.Hotel;
import main.java.connector.intefaces.impl.tbo.search.TBOHotel;

public class TBOHotelProcessor {

    public static List<Hotel> processResponse(List<TBOHotel> tboHotels) {
        List<Hotel> hotelList=new LinkedList<Hotel>();
        for(TBOHotel hotel:tboHotels){
            hotelList.add(new TBOHotelAdapter(hotel));
        }
        return hotelList;
    }

}
