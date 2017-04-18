package com.retro.vaadin.kit.uihelper.components.table;

import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Vinayak More
 *
 * @date 18-Apr-2017
 */
public abstract class AbstractColumnGenerator<T> implements ColumnGenerator {

    private static final long serialVersionUID = -6421279304444048110L;

    @Override
    public Object generateCell(Table source, Object itemId, Object columnId) {
        HorizontalLayout hlayout = new HorizontalLayout();
        @SuppressWarnings("unchecked")
        final T bean = (T) ((BeanItem<T>) source.getItem(itemId)).getBean();
        hlayout.setSpacing(true);
        Button edit = new Button("", new ClickListener() {

            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                editClickAction(bean);
            }
        });
        edit.setIcon(FontAwesome.EDIT);
        edit.addStyleName(ValoTheme.BUTTON_LINK);
        edit.setId("edit-" + itemId.toString());
        Button delete = new Button("", new ClickListener() {

            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                deleteClickAction(bean);
            }
        });
        delete.setIcon(FontAwesome.TRASH);
        delete.addStyleName(ValoTheme.BUTTON_LINK);
        delete.setId("delete-" + itemId.toString());
        hlayout.addComponents(edit, delete);
        return hlayout;
    }

    protected abstract void editClickAction(final T bean);

    protected abstract void deleteClickAction(final T bean);

}
