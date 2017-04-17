/**
 * @author Vinayak More
 * @date 17-Apr-2017
 */
package com.retro.vaadin.module.investment.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.retro.web.bean.Investment;
import com.retro.web.bean.User;
import com.retro.web.service.PortfolioService;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringComponent
public class InvestmentDelegate {

    @Autowired
    private PortfolioService service;

    public List<Investment> getAllInvestments() {
        return service.getAllInvestments(getUserId());
    }

    public boolean refreshInvestmentData() {
        return service.refreshInvestmentData(getUserId());
    }

    private Long getUserId() {
        return (Long) VaadinSession.getCurrent().getAttribute(User.class.getName());
    }

}
