package com.retro.web.bean;

import java.util.Date;

import com.retro.web.bean.Constants.Market;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
public class Transaction {

    public enum Type {
        BUY("BUY"), SELL("SELL");
        private String value;

        private Type(String s) {
            this.value = s;
        }

        public String toString() {
            return value;
        }
    }
    private Long rid;
    private Long userId;
    private Date transactionTime=new Date();
    private Type type;
    private Market market;
    private String symbol;
    private Integer quantity= new Integer(0);
    private Double pricePerStock =new Double(0);
    private Double priceInTotal =new Double(0);
    private Date creationDatetime = new Date();
    private Date lastmodDatetime = new Date();
    private Stock stock;
    private int stockId;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerStock() {
        return pricePerStock;
    }

    public void setPricePerStock(Double pricePerStock) {
        this.pricePerStock = pricePerStock;
    }

    public Double getPriceInTotal() {
        return priceInTotal;
    }

    public void setPriceInTotal(Double priceInTotal) {
        this.priceInTotal = priceInTotal;
    }

    public Date getCreationDatetime() {
        return creationDatetime;
    }

    public void setCreationDatetime(Date creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public Date getLastmodDatetime() {
        return lastmodDatetime;
    }

    public void setLastmodDatetime(Date lastmodDatetime) {
        this.lastmodDatetime = lastmodDatetime;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Override
    public String toString() {
        return String
                .format("Transaction [rid=%s, userId=%s, transactionTime=%s, type=%s, market=%s, symbol=%s, quantity=%s, pricePerStock=%s, priceInTotal=%s, creationDatetime=%s, lastmodDatetime=%s]",
                        rid, userId, transactionTime, type, market, symbol, quantity, pricePerStock, priceInTotal,
                        creationDatetime, lastmodDatetime);
    }
    
}
