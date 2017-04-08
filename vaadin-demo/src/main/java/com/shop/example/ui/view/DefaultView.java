/**
 * @author Vinayak More
 *
 * @date 19-Nov-2016
 */
package com.shop.example.ui.view;

import javax.annotation.PostConstruct;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;

@VaadinSessionScope
@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
    private static final long serialVersionUID = -1636387685666427664L;
    public static final String VIEW_NAME = "";
    private VerticalLayout layout;
    private PopupDateField datefield;
    Tree menu;
    TextField child;
    Button add;

    @PostConstruct
    public void init() {
        layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setSizeUndefined();
        layout.addComponent(new Label("This is the default view"));
        initDateField();
        layout.addComponent(datefield);
        test();
        // test2();
        treeTable();
        layout.addComponent(menu);
        layout.addComponents(child, add);
        addComponent(layout);
    }

    private void initDateField() {
        datefield = new PopupDateField("Select Date");
        datefield.setResolution(Resolution.DAY);
        datefield.addValueChangeListener(new ValueChangeListener() {

            private static final long serialVersionUID = 2493895380511920502L;

            @Override
            public void valueChange(ValueChangeEvent event) {
                Notification.show(event.getProperty().getValue().toString(), Type.WARNING_MESSAGE);
            }
        });
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    public void test() {
        // A menu tree
        menu = new Tree();
        menu.addContainerProperty("", Component.class, null);

        // Couple of childless root items
        menu.addItem(new Label("Mercury"));
        menu.addItem("Venus");

        // An item with hierarchy
        menu.addItem("Earth");
        menu.addItem("The Moon");
        menu.setChildrenAllowed("The Moon", false);
        menu.setParent("The Moon", "Earth");
        menu.expandItem("Earth"); // Expand programmatically
        // menu.addItemClickListener(new ItemClickListener() {
        //
        // @Override
        // public void itemClick(ItemClickEvent event) {
        // Notification.show("Item clicked :"+event.getItemId(), Type.WARNING_MESSAGE);
        // Property property = menu.getContainerProperty(event.getItemId(), event.getPropertyId());
        // TextField field = new TextField(event.getItemId().toString());
        // field.addBlurListener(new BlurListener() {
        //
        // @Override
        // public void blur(BlurEvent event) {
        // // TODO Auto-generated method stub
        // property.setValue(field.getValue());
        // }
        // });
        // property.setValue(field);
        // // menu.addItem(field);
        // // menu.setParent(field, event.getItemId());
        // }
        // });

        child = new TextField("Enter child");

        add = new Button("Add", new ClickListener() {

            private static final long serialVersionUID = -4127002490924529522L;

            @Override
            public void buttonClick(ClickEvent event) {
                menu.addItem(child.getValue());
                menu.setParent(child.getValue(), menu.getValue());
                menu.expandItem(menu.getValue());
            }
        });
    }

    @SuppressWarnings({"deprecation", "unchecked"})
    private void test2() {
        final Table table = new Table();
        table.setWidth(100, Sizeable.UNITS_PERCENTAGE);
        table.setSelectable(true);
        // table.setMultiSelectMode(MultiSelectMode.DEFAULT);
        table.setMultiSelect(false);
        table.setNullSelectionAllowed(false);
        table.setImmediate(true);
        table.addContainerProperty("foo", Component.class, null);
        table.addContainerProperty("bar", Component.class, null);

        table.addListener(new ItemClickListener() {

            private static final long serialVersionUID = -2584507966098855569L;

            @Override
            public void itemClick(ItemClickEvent event) {
                Object itemId = event.getItemId();
                if (table.isSelected(itemId)) {
                    final Property containerProperty = table.getContainerProperty(itemId, event.getPropertyId());
                    Property property = (Property) containerProperty.getValue();
                    if (property instanceof Label) {
                        String propertyId = (String) event.getPropertyId();
                        final TextField field = new TextField();
                        field.setValue((String) property.getValue());
                        field.addListener(new BlurListener() {

                            private static final long serialVersionUID = 4743029510779065686L;

                            @Override
                            public void blur(BlurEvent event) {
                                containerProperty.setValue(new Label("" + field.getValue()));
                            }
                        });
                        containerProperty.setValue(field);
                        field.focus();
                    }
                }
            }
        });

        for (int i = 0; i < 200; i++) {
            table.getContainerProperty(table.addItem(), "foo").setValue(new Label("" + i));
        }

        layout.addComponent(table);
    }

    @SuppressWarnings("deprecation")
    public void treeTable() {
        HorizontalLayout hLayout=new HorizontalLayout();
        TreeTable ttable = new TreeTable("My TreeTable");
        ttable.setMultiSelect(false);
        ttable.setNullSelectionAllowed(false);
        ttable.setImmediate(true);
        ttable.setSelectable(true);
        ttable.addContainerProperty("Name", Component.class, new Label(""));
        ttable.addContainerProperty("Number", Component.class, new Label(""));
        ttable.addContainerProperty("Action", Button.class, null);
        // Create the tree nodes and set the hierarchy
        ttable.addItem(new Object[] {new Label("Menu"), new Label(""), new Button("Update")}, 0);
        ttable.addItem(new Object[] {new Label("Beverages"), new Label(""), new Button("Update")}, 1);
        ttable.setParent(1, 0);
        ttable.addItem(new Object[] {new Label("Foods"), new Label(""), new Button("Update")}, 2);
        ttable.setParent(2, 0);
        ttable.addItem(new Object[] {new Label("Coffee"), new Label("23"), new Button("Update")}, 3);
        ttable.addItem(new Object[] {new Label("Tea"), new Label("42"), new Button("Update")}, 4);
        ttable.setParent(3, 1);
        ttable.setParent(4, 1);
        ttable.addItem(new Object[] {new Label("Bread"), new Label("13"), new Button("Update")}, 5);
        ttable.addItem(new Object[] {new Label("Cake"), new Label("11"), new Button("Update")}, 6);
        ttable.setParent(5, 2);
        ttable.setParent(6, 2);
        ttable.setSizeUndefined();
        ttable.setPageLength(7);
        ttable.addListener(new ItemClickListener() {

            private static final long serialVersionUID = -2584507966098855569L;

            @Override
            public void itemClick(ItemClickEvent event) {
                Object itemId = event.getItemId();
                if (ttable.isSelected(itemId)) {
                    final Property containerProperty = ttable.getContainerProperty(itemId, event.getPropertyId());
                    Property property = (Property) containerProperty.getValue();
                    if (property instanceof Label) {
                        String propertyId = (String) event.getPropertyId();
                        final TextField field = new TextField();
                        field.setValue((String) property.getValue());
                        field.addListener(new BlurListener() {

                            private static final long serialVersionUID = 4743029510779065686L;

                            @Override
                            public void blur(BlurEvent event) {
                                containerProperty.setValue(new Label("" + field.getValue()));
                            }
                        });
                        containerProperty.setValue(field);
                        field.focus();
                    }
                }
            }
        });
        hLayout.addComponent(ttable);
        TextField item=new TextField("Enter new category");
        Button add=new Button("Add", new ClickListener() {
            
            @Override
            public void buttonClick(ClickEvent event) {
                int size = ttable.size();
                ttable.addItem(new Object[] {new Label(item.getValue()), new Label(""), new Button("Update")}, ++size);
                ttable.setParent(item.getValue(), ttable.getValue());
            }
        });
        VerticalLayout vLayout=new VerticalLayout(item,add);
        vLayout.setSpacing(true);
        hLayout.addComponent(vLayout);
        layout.addComponent(hLayout);

    }

}
