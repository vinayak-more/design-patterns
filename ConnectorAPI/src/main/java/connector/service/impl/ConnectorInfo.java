/**
 * @author Vinayak More
 *
 * @date 10-Dec-2016
 */
package main.java.connector.service.impl;

public class ConnectorInfo {
    boolean isInternational;
    String connector;

    public ConnectorInfo(boolean isInternational, String connector) {
        super();
        this.isInternational = isInternational;
        this.connector = connector;
    }
}
