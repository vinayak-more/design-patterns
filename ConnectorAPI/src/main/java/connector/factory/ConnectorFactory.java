/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.factory;

import java.util.LinkedList;
import java.util.List;

import main.java.connector.intefaces.ConnectorConstants;
import main.java.connector.intefaces.HotelConnector;
import main.java.connector.intefaces.impl.rezlive.RezliveHotelConnector;
import main.java.connector.intefaces.impl.tbo.TBOHotelConnector;
import main.java.connector.intefaces.impl.tg.TGHotelConnector;
import main.java.connector.service.ConnectorService;
import main.java.connector.service.impl.ConnectorServiceImpl;
import main.java.connector.user.User;

public class ConnectorFactory {

    private static ConnectorService service = new ConnectorServiceImpl();

    public static List<HotelConnector> getConnectors(User user, boolean isInternational) {
        List<HotelConnector> list = new LinkedList<HotelConnector>();
        for (String connector : service.getConnectedConnectors(user, isInternational)) {
            switch (connector) {
                case ConnectorConstants.REZLIVE_HOTEL:
                    list.add(new RezliveHotelConnector());
                    break;
                case ConnectorConstants.TBO_HOTEL:
                    list.add(new TBOHotelConnector());
                    break;
                case ConnectorConstants.TG_HOTEL:
                    list.add(new TGHotelConnector());
                    break;
                case ConnectorConstants.TBO_INT_HOTEL:
                    list.add(new TBOHotelConnector());
                    break;
                default:
                    break;
            }
        }
        return list;
    }
}
