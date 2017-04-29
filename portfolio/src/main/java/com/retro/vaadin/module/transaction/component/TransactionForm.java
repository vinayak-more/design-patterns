package com.retro.vaadin.module.transaction.component;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.retro.vaadin.module.transaction.event.AddTransactionEvent;
import com.retro.web.bean.Constants.Market;
import com.retro.web.bean.Transaction;
import com.retro.web.bean.Transaction.Type;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Vinayak More
 *
 * @date 29-Apr-2017
 */
@SpringComponent
@VaadinSessionScope
public class TransactionForm extends FormLayout {

    private static final long serialVersionUID = 1L;
    private TextField quantity = new TextField("Quantity");
    private TextField pricePerStock = new TextField("Price per Stock");
    private TextField priceInTotal = new TextField("Total Investment");
    private ComboBox<Type> type = new ComboBox<>("Type", Arrays.asList(Type.BUY, Type.SELL));
    private ComboBox<Market> market = new ComboBox<>("Market", Arrays.asList(Market.NSE, Market.BSE));
    private TextField symbol = new TextField("Symbol");
    private DateField transactionTime = new DateField();
    private Button save, cancel;
    private Binder<Transaction> binder = new Binder<Transaction>(Transaction.class);

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostConstruct
    public void init() {
        binder.forField(quantity).withConverter(new StringToIntegerConverter("Please enter valid field"))
                .bind("quantity");
        binder.forField(pricePerStock).withConverter(new StringToDoubleConverter("Please enter valid field"))
                .bind("pricePerStock");
        binder.forField(priceInTotal).withConverter(new StringToDoubleConverter("Please enter valid field"))
                .bind("priceInTotal");
        binder.forField(transactionTime).withConverter(new LocalDateToDateConverter()).bind("transactionTime");
        binder.bindInstanceFields(this);
        save = new Button("Save", e -> {
            if (binder.validate().isOk()) {
                publisher.publishEvent(new AddTransactionEvent(binder.getBean()));
                setVisible(false);
            }
        });
        save.addStyleName(ValoTheme.BUTTON_PRIMARY);
        cancel = new Button("Cancel", e -> {
            binder.removeBean();
            setVisible(false);
        });
        cancel.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        addComponents(market, type, symbol, transactionTime, quantity, pricePerStock, priceInTotal);
        addComponent(new HorizontalLayout(save, cancel));
    }

    public void setBean(Transaction transaction) {
        binder.setBean(transaction);
    }



}
