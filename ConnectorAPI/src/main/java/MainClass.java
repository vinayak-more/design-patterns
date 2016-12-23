/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java;

import java.util.List;

import main.java.connector.factory.ConnectorFactory;
import main.java.connector.intefaces.HotelConnector;
import main.java.connector.user.User;
import main.java.connector.user.impl.DefaultUser;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("User-1----------------->>>>>>> false");
        User user1 = DefaultUser.USERS.USER1.getUser();
        for (HotelConnector connector : ConnectorFactory.getConnectors(user1, false)) {
            showResult(connector.search());
        }
        System.out.println("\n\n\nUser-2----------------->>>>>>> true");
        User user2 = DefaultUser.USERS.USER2.getUser();
        for (HotelConnector connector : ConnectorFactory.getConnectors(user2, false)) {
            showResult(connector.search());
        }
        System.out.println("\n\n\nUser-3----------------->>>>>>> true");
        User user3 = DefaultUser.USERS.USER3.getUser();
        for (HotelConnector connector : ConnectorFactory.getConnectors(user3, true)) {
            showResult(connector.search());
        }
    }

    public static void showResult(List<Hotel> result) {
        if (result != null && !result.isEmpty()) {
            for (Hotel hotel : result) {
                System.out.println(hotel);
            }
        }
    }
    
    
}
