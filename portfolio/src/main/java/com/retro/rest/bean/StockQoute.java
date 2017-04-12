package com.retro.rest.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class StockQoute {

    private final Double currentPrice;
    private final Double previousClose;
    private final Double closingPrice;

    public StockQoute() {
        super();
        currentPrice = 0D;
        previousClose = 0D;
        closingPrice = 0D;
    }

    public StockQoute(Double currentPrice, Double previousClose, Double closingPrice) {
        super();
        this.currentPrice = currentPrice;
        this.previousClose = previousClose;
        this.closingPrice = closingPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public Double getClosingPrice() {
        return closingPrice;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
