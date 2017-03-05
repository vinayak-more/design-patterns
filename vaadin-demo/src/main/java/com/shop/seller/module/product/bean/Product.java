/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.bean;

/**
 *
 */
public class Product {

    private int rid;
    private String productId;
    private String productName;
    private Double price;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isNew() {
        return rid == 0;
    }

    @Override
    public String toString() {
        return "Product [rid=" + rid + ", productId=" + productId + ", productName=" + productName + ", price=" + price
                + "]";
    }

}
