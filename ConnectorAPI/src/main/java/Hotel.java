/**
 * @author Vinayak More
 *
 * @date 14-Dec-2016
 */
package main.java;

public class Hotel {
    private String name;
    private String address;
    private String rating;
    private long price;
    private String connector;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    @Override
    public String toString() {
        return "Hotel [name=" + getName() + ", address=" + getAddress() + ", rating=" + getRating() + ", price=" + getPrice()
                + ", connector=" + getConnector() + "]";
    }

}
