package com.retro.vaadin.module.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import com.retro.vaadin.kit.uihelper.view.AbstractController;
import com.retro.vaadin.module.transaction.delegate.TransactionDelegate;
import com.retro.vaadin.module.transaction.event.AddTransactionEvent;
import com.retro.web.bean.Transaction;
import com.vaadin.spring.annotation.SpringComponent;

/**
 * @author Vinayak More
 *
 * @date 18-Apr-2017
 */
@SpringComponent
public class TransactionController extends AbstractController<TransactionView> {

    @Autowired
    private TransactionDelegate delegate;
    
    @Override
    public void onViewEnter() {
        getView().setList(delegate.getAllTransaction());

    }
    
    @EventListener
    public void onAddTransactionEvent(AddTransactionEvent event){
        delegate.save(event.getBean());
        getView().setList(delegate.getAllTransaction());
    }

}
