package com.retro.vaadin.module.transaction.component;

import org.springframework.context.annotation.Scope;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;

/**
 * @author Vinayak More
 *
 * @date 01-May-2017
 */
@SpringComponent
@Scope("prototype")
public class SuggestBox extends CustomComponent {
    ComboBox<SuggestItem> cd = new ComboBox<SuggestItem>();

    private static final long serialVersionUID = 1L;
    private SuggestDataProvider dataProvider = new SuggestDataProvider();

    public SuggestBox() {
        this("");
    }

    public SuggestBox(String caption) {
        cd.setCaption(caption);
        cd.setDataProvider(dataProvider);
        setCompositionRoot(cd);
    }


}
