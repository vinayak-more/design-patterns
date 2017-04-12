package com.retro.web.bean;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Vinayak More
 *
 * @date 11-Apr-2017
 */

public class Investment {

    private Long rid;
    private Long userId;
    private String symbol;
    private int quantity;
    private Double investment;
    private Double currentValue;
    private Double changeValue;
    private Double changePercentage;
    private Double todaysGain;
    private Date lasUpdated;

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public Double getChangeValue() {
        return changeValue;
    }

    public void setChangeValue(Double changeValue) {
        this.changeValue = changeValue;
    }

    public Double getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(Double changePercentage) {
        this.changePercentage = changePercentage;
    }

    public Double getTodaysGain() {
        return todaysGain;
    }

    public void setTodaysGain(Double todaysGain) {
        this.todaysGain = todaysGain;
    }

    public Date getLasUpdated() {
        return lasUpdated;
    }

    public void setLasUpdated(Date lasUpdated) {
        this.lasUpdated = lasUpdated;
    }

    public Double getInvestment() {
		return investment;
	}

	public void setInvestment(Double investment) {
		this.investment = investment;
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
