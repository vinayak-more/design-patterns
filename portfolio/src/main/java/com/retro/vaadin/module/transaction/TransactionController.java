package com.retro.vaadin.module.transaction;

import org.springframework.beans.factory.annotation.Autowired;

import com.retro.vaadin.kit.uihelper.view.AbstractController;
import com.retro.vaadin.module.transaction.delegate.TransactionDelegate;
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

}
