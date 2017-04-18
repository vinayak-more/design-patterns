package com.retro.web.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.retro.rest.bean.StockQoute;
import com.retro.rest.client.GoogleFinanceRestClient;
import com.retro.web.bean.Investment;
import com.retro.web.bean.Transaction;
import com.retro.web.repository.PortfolioRepository;

/**
 * @author Vinayak More
 *
 * @date 11-Apr-2017
 */
@Service
public class PortfolioService {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PortfolioRepository repository;

    @Autowired
    private GoogleFinanceRestClient restClient;

    public List<Investment> getAllInvestments(Long userId) {
        return repository.getAllInvestments(userId);
    }

    private boolean updateAllInvestments(Collection<Investment> investments) {
        return repository.updateAllInvestments(investments);
    }

    public boolean refreshInvestmentData(Long userId) {
        if (userId == null || userId.longValue() == 0) {
            return false;
        }
        List<Transaction> allTransactions = transactionService.getAllTransaction(userId);
        if (CollectionUtils.isEmpty(allTransactions)) {
            return false;
        }
        Map<String, Investment> investmentSummery = getInvestmentSummery(userId, allTransactions);
        for (String key : investmentSummery.keySet()) {
            Investment investment = investmentSummery.get(key);
            StockQoute qoute = restClient.getQoute(key).getStockQoute();
            double currentValue = investment.getQuantity() * qoute.getCurrentPrice();
            investment.setCurrentValue(getRoundedValue(currentValue));
            double changeValue = investment.getCurrentValue() - investment.getInvestment();
            investment.setChangeValue(getRoundedValue(changeValue));
            double changePercentage = investment.getChangeValue() * 100 / investment.getInvestment();
            investment.setChangePercentage(getRoundedValue(changePercentage));
            Double todaysGain = currentValue - (investment.getQuantity() * qoute.getPreviousClose());
            investment.setTodaysGain(getRoundedValue(todaysGain));
            System.out.println(investment);
        }
        return updateAllInvestments(investmentSummery.values());
    }

    private Map<String, Investment> getInvestmentSummery(Long userId, List<Transaction> allTransactions) {
        Map<String, Investment> investmentMap = new HashMap<String, Investment>();
        for (Transaction transaction : allTransactions) {
            if (investmentMap.get(transaction.getSymbol()) == null) {
                Investment value = new Investment();
                value.setSymbol(transaction.getSymbol());
                value.setUserId(userId);
                value.setLasUpdated(new Timestamp(System.currentTimeMillis()));
                value.setChangePercentage(0D);
                value.setChangeValue(0D);
                value.setTodaysGain(0D);
                value.setInvestment(0D);
                value.setQuantity(0);
                investmentMap.put(transaction.getSymbol(), value);
            }
            Investment investment = investmentMap.get(transaction.getSymbol());
            if (transaction.getType().equals(Transaction.Type.BUY)) {
                investment.setInvestment(investment.getInvestment() + transaction.getPriceInTotal());
                investment.setQuantity(investment.getQuantity() + transaction.getQuantity());
            } else {
                investment.setInvestment(investment.getInvestment() - transaction.getPriceInTotal());
                investment.setQuantity(investment.getQuantity() - transaction.getQuantity());
            }

        }
        return investmentMap;
    }

    private Double getRoundedValue(Double value) {
        return (double) Math.round(value * 100000d) / 100000d;

    }
}
