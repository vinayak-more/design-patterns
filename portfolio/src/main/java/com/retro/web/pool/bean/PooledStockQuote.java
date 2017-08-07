package com.retro.web.pool.bean;

/**
 * @author Vinayak More
 *
 * @date 07-Aug-2017
 */
public class PooledStockQuote {

    private String symbol;
    private double currentPrice;
    private double lastClosePrice;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getLastClosePrice() {
        return lastClosePrice;
    }

    public void setLastClosePrice(double lastClosePrice) {
        this.lastClosePrice = lastClosePrice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(currentPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lastClosePrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PooledStockQuote other = (PooledStockQuote) obj;
        if (Double.doubleToLongBits(currentPrice) != Double.doubleToLongBits(other.currentPrice))
            return false;
        if (Double.doubleToLongBits(lastClosePrice) != Double.doubleToLongBits(other.lastClosePrice))
            return false;
        if (symbol == null) {
            if (other.symbol != null)
                return false;
        } else if (!symbol.equals(other.symbol))
            return false;
        return true;
    }

}
