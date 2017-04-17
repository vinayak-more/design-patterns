package com.retro.vaadin.module.investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import com.retro.vaadin.kit.uihelper.view.AbstractController;
import com.retro.vaadin.module.investment.delegate.InvestmentDelegate;
import com.retro.vaadin.module.investment.event.RefreshInvestmentData;
import com.vaadin.spring.annotation.SpringComponent;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringComponent
public class InvestmentController extends AbstractController<InvestmentView> {

    @Autowired
    private InvestmentDelegate delegate;

    @Override
    public void onViewEnter() {
        getView().setList(delegate.getAllInvestments());
    }

    @EventListener
    public void onRefreshInvestmentData(RefreshInvestmentData event) {
        boolean b = delegate.refreshInvestmentData();
        if (b) {
            getView().setList(delegate.getAllInvestments());
        }
    }

}
