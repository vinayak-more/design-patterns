/**
 * @author Vinayak More
 *
 * @date 22-Dec-2016
 */
package main.java.connector.intefaces.impl.rezlive;

import java.util.LinkedList;
import java.util.List;

import main.java.Hotel;
import main.java.connector.intefaces.impl.rezlive.search.RezliveHotel;
import main.java.connector.intefaces.impl.rezlive.search.RezliveHotelAdapter;

public class RezliveHotelProcessor {

    public static List<Hotel> processResponse(List<RezliveHotel> hotelList) {
        List<Hotel> result=new LinkedList<Hotel>();
        for(RezliveHotel hotel:hotelList){
            result.add(new RezliveHotelAdapter(hotel));
        }
        return result;
    }

}
