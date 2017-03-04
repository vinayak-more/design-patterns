/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.uikit.common.uihelper.components.table;

import java.util.Collections;
import java.util.List;

import org.mockito.internal.util.collections.ArrayUtils;
import org.springframework.util.CollectionUtils;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

public class TableBuilder<T> extends CustomComponent {
    private static final long serialVersionUID = 1108827401382344579L;
    private Table table;
    private BeanItemContainer<T> container;
    private String[] columns;
    private Label noResultLabel = new Label("No results found", ContentMode.HTML);
    private List<T> itemList;


    public static <T> TableBuilder<T> createTable(Class<T> clazz, String... columns) {
        return new TableBuilder<T>(clazz, columns);
    }

    private TableBuilder(Class<T> clazz, String[] columns) {
        super();
        this.columns = columns;
        table = new VaadinTable();
        container = new BeanItemContainer<T>(clazz);
        table.setSortEnabled(false);
        table.addStyleName(ValoTheme.TABLE_COMPACT);
        table.addStyleName(ValoTheme.TABLE_NO_HORIZONTAL_LINES);
        table.setSizeFull();
        this.table.setColumnCollapsingAllowed(true);
        setCompositionRoot(table);
        createTable();
    }

    private void createTable() {
        itemList = Collections.emptyList();
        container.addAll(itemList);
        table.setContainerDataSource(container);
        if (columns != null || columns.length > 0) {
            table.setVisibleColumns(columns);
        }
    }

    public void setList(List<T> itemList) {
        this.itemList = itemList;
        updateTable();
    }

    public void updateTable() {
        container.removeAllItems();
        if (CollectionUtils.isEmpty(itemList)) {
            setCompositionRoot(noResultLabel);
        } else {
            container.addAll(itemList);
            setCompositionRoot(table);
        }
    }
}
