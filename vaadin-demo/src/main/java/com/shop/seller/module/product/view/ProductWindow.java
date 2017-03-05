/**
 * @author Vinayak More
 *
 * @date 05-Mar-2017
 */
package com.shop.seller.module.product.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.shop.seller.module.product.bean.Product;
import com.shop.seller.module.product.view.event.SaveProductEvent;
import com.shop.uikit.common.uihelper.components.TextFieldHelper;
import com.shop.uikit.common.uihelper.error.ErrorUtils;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
public class ProductWindow extends Window {

    private static final long serialVersionUID = -2410982854608046759L;
    private TextField productId;
    private TextField productName;
    private TextField price;
    private Button save, edit, cancel;
    private Label title;
    private VerticalLayout vLayout;
    private HorizontalLayout bLayout;
    private HorizontalLayout layout;
    private BeanFieldGroup<Product> beanFieldGroup;

    @Autowired
    ApplicationEventPublisher publisher;


    @PostConstruct
    public void init() {
        productId = TextFieldHelper.helper("Product Id").required().getField();
        productName = TextFieldHelper.helper("Product Name").required().getField();
        price = TextFieldHelper.helper("Price").required().checkDouble().getField();
        initButtons();
        title = new Label();
        layout = new HorizontalLayout(productId, productName, price, edit);
        layout.setSpacing(true);
        bLayout = new HorizontalLayout(save, cancel);
        bLayout.setSpacing(true);
        bLayout.setSizeFull();
        bLayout.setComponentAlignment(save, Alignment.MIDDLE_RIGHT);
        bLayout.setComponentAlignment(cancel, Alignment.MIDDLE_LEFT);
        vLayout = new VerticalLayout(title, layout, bLayout);
        vLayout.setMargin(true);
        vLayout.setSpacing(true);
        beanFieldGroup = new BeanFieldGroup<Product>(Product.class);
        beanFieldGroup.bindMemberFields(this);
        setContent(vLayout);
        center();
        setModal(true);
        setResizable(false);
        // setClosable(false);
    }

    private void initButtons() {
        save = new Button("Save");
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.addClickListener(e -> saveBean());
        edit = new Button();
        edit.addClickListener(e -> setEditMode());
        edit.setIcon(FontAwesome.EDIT);
        edit.setStyleName(ValoTheme.BUTTON_ICON_ONLY);
        cancel = new Button("Cancel", e -> close());
    }

    private void saveBean() {
        try {
            beanFieldGroup.commit();
            publisher.publishEvent(new SaveProductEvent(beanFieldGroup.getItemDataSource().getBean()));
            close();
        } catch (CommitException e) {
            ErrorUtils.showValidationVisible(beanFieldGroup.getFields(), true);
        }
    }

    private void setEditMode() {
        edit.setVisible(false);
        productId.setReadOnly(false);
        productName.setReadOnly(false);
        price.setReadOnly(false);
        save.setVisible(true);
        cancel.setVisible(true);
    }

    public void setBean(Product bean) {
        setTitle(bean);
        setEditMode();
        beanFieldGroup.setItemDataSource(bean);
        if (!bean.isNew()) {
            setViewMode();
        }
    }

    private void setTitle(Product bean) {
        String titleStr;
        if (bean.isNew()) {
            titleStr = "Enter Details for New Product";
        } else {
            titleStr = "Product :" + bean.getProductName();
        }
        title.setCaption(titleStr);
    }

    private void setViewMode() {
        edit.setVisible(true);
        productId.setReadOnly(true);
        productName.setReadOnly(true);
        price.setReadOnly(true);
        save.setVisible(false);
        cancel.setVisible(false);
    }
}
