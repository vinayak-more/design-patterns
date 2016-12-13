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

    Map<String, List<ConnectorInfo>> inMemoryConnectorMap = new HashMap<String, List<ConnectorInfo>>();

    public ConnectorServiceImpl() {
        super();
        initInMemoryConnectorMap();
    }

    private void initInMemoryConnectorMap() {
        String user1 = "USER-1";
        List<ConnectorInfo> user1connectors =
                Arrays.asList(new ConnectorInfo[] {new ConnectorInfo(false, ConnectorConstants.TG_HOTEL),
                        new ConnectorInfo(false, ConnectorConstants.TBO_HOTEL),
                        new ConnectorInfo(true, ConnectorConstants.REZLIVE_HOTEL)});
        inMemoryConnectorMap.put(user1, user1connectors);

        String user2 = "USER-2";
        List<ConnectorInfo> user2connectors =
                Arrays.asList(new ConnectorInfo[] {new ConnectorInfo(false, ConnectorConstants.TG_HOTEL),
                        new ConnectorInfo(false, ConnectorConstants.TBO_HOTEL)});
        inMemoryConnectorMap.put(user2, user2connectors);

        String user3 = "USER-3";
        List<ConnectorInfo> user3connectors =
                Arrays.asList(new ConnectorInfo[] {new ConnectorInfo(false, ConnectorConstants.TG_HOTEL),
                        new ConnectorInfo(true, ConnectorConstants.TBO_INT_HOTEL),
                        new ConnectorInfo(true, ConnectorConstants.REZLIVE_HOTEL)});
        inMemoryConnectorMap.put(user3, user3connectors);
    }

    @Override
    public List<String> getConnectedConnectors(User user, boolean isInternational) {
        List<String> connectors = new LinkedList<String>();
        for (ConnectorInfo info : inMemoryConnectorMap.get(user.getUserName())) {
            if (isInternational == info.isInternational) {
                connectors.add(info.connector);
            }
        }
        return connectors;
    }

}
