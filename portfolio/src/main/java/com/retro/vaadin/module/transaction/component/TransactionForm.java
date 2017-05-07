package com.retro.vaadin.module.transaction.component;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.retro.vaadin.module.transaction.event.AddTransactionEvent;
import com.retro.vaadin.module.transaction.event.StockSelectEvent;
import com.retro.vaadin.module.transaction.event.UpdateTransactionEvent;
import com.retro.web.bean.Constants.Market;
import com.retro.web.bean.Transaction;
import com.retro.web.bean.Transaction.Type;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.shared.Registration;
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
    private StockSuggestBox stock = new StockSuggestBox("Stock");
    private DateField transactionTime = new DateField();
    private Button save = new Button("Save");
    private Button update = new Button("Update");
    private Button cancel = new Button("Cancel");
    private Binder<Transaction> binder = new Binder<Transaction>(Transaction.class);

    @Autowired
    private ApplicationEventPublisher publisher;
    private Registration quantityRegst;
    private Registration stockRegst;
    private Transaction transaction;

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
        save.addClickListener(e -> {
            if (binder.writeBeanIfValid(transaction)) {
                publisher.publishEvent(new AddTransactionEvent(transaction));
                setVisible(false);
            }
        });
        save.addStyleName(ValoTheme.BUTTON_PRIMARY);
        update.addClickListener(e -> {
            if (binder.writeBeanIfValid(transaction)) {
                publisher.publishEvent(new UpdateTransactionEvent(transaction));
                setVisible(false);
            }
        });
        update.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        update.setVisible(false);
        cancel.addClickListener(e -> {
            binder.removeBean();
            setVisible(false);
        });

        priceInTotal.setEnabled(false);
        addComponents(market, type, stock, transactionTime, quantity, pricePerStock, priceInTotal);
        addComponent(new HorizontalLayout(save, update, cancel));
    }

    public void setBean(Transaction transaction) {
        this.transaction = transaction;
        removeListeners();
        binder.readBean(transaction);
        addListeners();
    }

    private void addListeners() {
        stockRegst =
                stock.addValueChangeListener(e -> publisher.publishEvent(new StockSelectEvent(stock.getValue(),
                        getThis())));
        quantityRegst = quantity.addValueChangeListener(e -> {
            try {
                Integer q = new Integer(quantity.getValue());
                Double p = new Double(pricePerStock.getValue());
                priceInTotal.setValue(String.valueOf(p * q));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    private void removeListeners() {
        if (stockRegst != null) {
            stockRegst.remove();
        }
        if (quantityRegst != null) {
            quantityRegst.remove();
        }
    }

    private TransactionForm getThis() {
        return this;
    }

    public void setCurrentStockPrice(double price) {
        pricePerStock.setValue(String.valueOf(price));
    }

    public void setUpdateMode(boolean isUpdate) {
        update.setVisible(isUpdate);
        save.setVisible(!isUpdate);
    }


}
