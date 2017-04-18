/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.retro.vaadin.kit.uihelper.components.table;

import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.themes.ValoTheme;

public class VaadinTable<T> extends CustomComponent {
    private static final long serialVersionUID = 1108827401382344579L;
    private Table table;
    private BeanItemContainer<T> container;
    private String[] columns;
    private Label noResultLabel = new Label("No results found", ContentMode.HTML);
    private List<T> itemList;
    private int autoLenght;

    public static <T> VaadinTable<T> createTable(Class<T> clazz, String... columns) {
        return new VaadinTable<T>(clazz, columns);
    }

    private VaadinTable(Class<T> clazz, String... columns) {
        super();
        this.columns = columns;
        table = new CustomTable();
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
            table.setVisibleColumns((Object[]) columns);
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
        if (autoLenght > 0) {
            updateTableLength();
        }
    }

    public void setColumnComponent(String columnId, ColumnGenerator colGenerator) {
        table.addGeneratedColumn(columnId, colGenerator);
    }

    private void updateTableLength() {
        table.setPageLength(itemList.size() >= autoLenght ? autoLenght : itemList.size());
    }

    public Table getTable() {
        return table;
    }

    public void setHeaders(String... headers) {
        table.setColumnHeaders(headers);
    }

    public void setPageLength(int pageLength) {
        table.setPageLength(pageLength);
    }

    public void setAutoLenghtEnable(int autoPageLength) {
        autoLenght = autoPageLength;
    }

}
