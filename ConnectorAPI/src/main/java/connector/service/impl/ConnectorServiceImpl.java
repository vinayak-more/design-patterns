/**
 * @author Vinayak More
 *
 * @date 09-Dec-2016
 */
package main.java.connector.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import main.java.connector.intefaces.ConnectorConstants;
import main.java.connector.service.ConnectorService;
import main.java.connector.user.User;

public class ConnectorServiceImpl implements ConnectorService {

    Map<String, List<String>> inMemoryConnectorMap = new HashMap<String, List<String>>();

    public ConnectorServiceImpl() {
        super();
        initInMemoryConnectorMap();
    }

    private void initInMemoryConnectorMap() {
        String user1 = "USER-1";
        List<String> user1connectors =
                Arrays.asList(new String[] {ConnectorConstants.TG_HOTEL, ConnectorConstants.TBO_HOTEL,
                        ConnectorConstants.REZLIVE_HOTEL});
        inMemoryConnectorMap.put(user1, user1connectors);

        String user2 = "USER-2";
        List<String> user2connectors =
                Arrays.asList(new String[] {ConnectorConstants.TG_HOTEL, ConnectorConstants.TBO_HOTEL});
        inMemoryConnectorMap.put(user2, user2connectors);

        String user3 = "USER-3";
        List<String> user3connectors = Arrays.asList(new String[] {ConnectorConstants.TG_HOTEL});
        inMemoryConnectorMap.put(user3, user3connectors);
    }

    @Override
    public List<String> getConnectedConnectors(User user) {
        List<String> connectors = inMemoryConnectorMap.get(user.getUserName());
        return connectors != null ? connectors : new LinkedList<String>();
    }

}
