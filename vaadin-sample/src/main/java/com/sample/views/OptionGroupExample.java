package com.sample.views;

import javax.annotation.PostConstruct;

import com.sample.bean.JournyBean;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Vinayak More
 *
 * @date 07-Apr-2017
 */
@SpringView(name = OptionGroupExample.NAME)
@VaadinSessionScope
public class OptionGroupExample extends VerticalLayout implements View {

    public static final String NAME = "option";
    private OptionGroup journyType;
    private Label saved;
    private Button save;
    private BeanFieldGroup<JournyBean> beanFieldGroup;

    @PostConstruct
    public void init() {
        beanFieldGroup = new BeanFieldGroup<JournyBean>(JournyBean.class);
        initComponent();
        beanFieldGroup.bindMemberFields(this);
        beanFieldGroup.setItemDataSource(new JournyBean());
        addComponentToLayout();

    }

    private void addComponentToLayout() {
        addComponent(journyType);
        addComponent(save);
        addComponent(saved);
    }

    private void initComponent() {
        journyType = new OptionGroup("Journy Type");
        journyType.addItems("One Way", "Round Trip");
        saved = new Label();
        save = new Button("Save", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                try {
                    beanFieldGroup.commit();
                    saved.setCaption(beanFieldGroup.getItemDataSource().getBean().getJournyType());
                } catch (CommitException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
