/**
 * @author Vinayak More
 *
 * @date 23-Dec-2016
 */
package main.java.connector.intefaces.impl.tg;

import java.util.LinkedList;
import java.util.List;

import main.java.Hotel;
import main.java.connector.intefaces.impl.tg.search.TGHotel;

public class TGHotelProcessor {

    public static List<Hotel> processResponse(List<TGHotel> tgHotels) {
        List<Hotel> hotelList=new LinkedList<Hotel>();
        for(TGHotel hotel:tgHotels){
            hotelList.add(new TGHotelAdapter(hotel));
        }
        return hotelList;
    }

}
