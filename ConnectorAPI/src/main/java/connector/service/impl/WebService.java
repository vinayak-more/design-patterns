/**
 * @author Vinayak More
 *
 * @date 22-Dec-2016
 */
package main.java.connector.service.impl;

import java.util.LinkedList;
import java.util.List;

import main.java.connector.intefaces.impl.rezlive.search.RezliveHotel;
import main.java.connector.intefaces.impl.tbo.search.TBOHotel;
import main.java.connector.intefaces.impl.tg.search.TGHotel;
import main.java.connector.intefaces.impl.tg.search.TGHotelDetails;

public class WebService {
    private static final WebService instance = new WebService();
    List<RezliveHotel> rezliveHotels = new LinkedList<RezliveHotel>();
    List<TGHotel> tgHotels = new LinkedList<TGHotel>();
    List<TBOHotel> tboHotels = new LinkedList<TBOHotel>();

    private WebService() {
        initRezliveHotels();
        initTGHotels();
        initTBOHotels();
    }

    private void initTBOHotels() {
        tboHotels.add(new TBOHotel("TBOHotel1", "300", "5", 5000, "TBOAddress1"));
        tboHotels.add(new TBOHotel("TBOHotel2", "301", "4", 4000, "TBOAddress2"));
        tboHotels.add(new TBOHotel("TBOHotel3", "302", "3", 3000, "TBOAddress3"));
    }

    private void initTGHotels() {
        tgHotels.add(new TGHotel("TGHotel1", "200", 5000, new TGHotelDetails("TGAddress1","5")));
        tgHotels.add(new TGHotel("TGHotel2", "201", 4000, new TGHotelDetails("TGAddress2","4")));
        tgHotels.add(new TGHotel("TGHotel3", "202", 3000, new TGHotelDetails("TGAddress3","3")));

    }

    private void initRezliveHotels() {
        rezliveHotels.add(new RezliveHotel("RezHotel1", "100", "5", 5000));
        rezliveHotels.add(new RezliveHotel("RezHotel2", "101", "4", 4000));
        rezliveHotels.add(new RezliveHotel("RezHotel3", "102", "3", 3000));
    }

    public List<RezliveHotel> getRezliveHotels() {
        return rezliveHotels;
    }

    public List<TGHotel> getTgHotels() {
        return tgHotels;
    }

    public List<TBOHotel> getTboHotels() {
        return tboHotels;
    }

    public static WebService getInstance() {
        return instance;
    }
}
