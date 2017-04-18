package com.retro.vaadin.module.investment.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.retro.vaadin.kit.AbstractDelegate;
import com.retro.web.bean.Investment;
import com.retro.web.service.PortfolioService;
import com.vaadin.spring.annotation.SpringComponent;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringComponent
public class InvestmentDelegate extends AbstractDelegate {

    @Autowired
    private PortfolioService service;

    public List<Investment> getAllInvestments() {
        return service.getAllInvestments(getUserId());
    }

    public boolean refreshInvestmentData() {
        return service.refreshInvestmentData(getUserId());
    }
}
