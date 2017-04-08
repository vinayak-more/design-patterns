package com.sample.views;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.bean.Person;
import com.sample.component.LastNameComponent;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Vinayak More
 *
 * @date 28-Mar-2017
 */
@SpringView(name = DefaultView.NAME)
@VaadinSessionScope
public class DefaultView extends VerticalLayout implements View {


    private static final long serialVersionUID = -5280141689583773262L;
    public static final String NAME = "";
    private TextField firstName;
    @Autowired
    private LastNameComponent lastNameComponent;
    private Person person;
    private BeanFieldGroup<Person> beanFieldGroup;


    @PostConstruct
    public void init() {
        firstName = new TextField("First Name");
        addComponent(firstName);
        addComponent(lastNameComponent);
        beanFieldGroup=new BeanFieldGroup<Person>(Person.class);
        beanFieldGroup.bindMemberFields(this);
        lastNameComponent.setBeanField(beanFieldGroup);
        beanFieldGroup.setItemDataSource(new Person());
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

}
