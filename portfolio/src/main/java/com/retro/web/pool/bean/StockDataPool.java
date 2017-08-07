package com.retro.web.pool.bean;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Component;

/**
 * @author Vinayak More
 *
 * @date 07-Aug-2017
 */
@Component
public class StockDataPool {

    private final Map<String, PooledStockQuote> pool = new ConcurrentHashMap<String, PooledStockQuote>();
    private final Set<String> listedStocks = new CopyOnWriteArraySet<String>();
    private Timestamp lastupdated;

    public Timestamp getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Timestamp lastupdated) {
        this.lastupdated = lastupdated;
    }

    public Map<String, PooledStockQuote> getPool() {
        return pool;
    }

    public PooledStockQuote getPooledQuote(String key) {
        return pool.get(key);
    }

    public Set<String> getListedStocks() {
        return listedStocks;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lastupdated == null) ? 0 : lastupdated.hashCode());
        result = prime * result + ((pool == null) ? 0 : pool.hashCode());
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
        StockDataPool other = (StockDataPool) obj;
        if (lastupdated == null) {
            if (other.lastupdated != null)
                return false;
        } else if (!lastupdated.equals(other.lastupdated))
            return false;
        if (pool == null) {
            if (other.pool != null)
                return false;
        } else if (!pool.equals(other.pool))
            return false;
        return true;
    }
}
