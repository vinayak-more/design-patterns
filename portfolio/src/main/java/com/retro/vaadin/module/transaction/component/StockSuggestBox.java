package com.retro.vaadin.module.transaction.component;

import org.springframework.context.annotation.Scope;

import com.retro.web.bean.Stock;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.ComboBox;

/**
 * @author Vinayak More
 *
 * @date 01-May-2017
 */
@SpringComponent
@Scope("prototype")
public class StockSuggestBox extends ComboBox<Stock> {

    private static final long serialVersionUID = 1L;
    private SuggestDataProvider dataProvider = new SuggestDataProvider();


    public StockSuggestBox() {
        this("");
    }

    public StockSuggestBox(String caption) {
        super(caption);
        setCaption(caption);
        setDataProvider(dataProvider);
        setItemCaptionGenerator(item -> item.getName());
    }


}
