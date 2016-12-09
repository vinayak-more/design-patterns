/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.service;

import java.util.List;

import main.java.connector.user.User;

public interface ConnectorService {

    public List<String> getConnectedConnectors(User user);
}
