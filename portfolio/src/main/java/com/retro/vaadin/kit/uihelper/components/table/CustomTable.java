/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.retro.vaadin.kit.uihelper.components.table;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.data.Property;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class CustomTable extends Table {
    @Override
    protected String formatPropertyValue(Object rowId, Object colId, Property<?> property) {
        if (property.getValue() != null) {
            // Format by property type
            if (property.getType() == Date.class) {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                if (property.getValue() instanceof Date) {
                    return df.format((Date) property.getValue());
                }
            }

            if (property.getType() == Timestamp.class) {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                if (property.getValue() instanceof Timestamp) {
                    return df.format((Timestamp) property.getValue());
                }
            }

            if (property.getType() == Boolean.class) {
                Boolean b = (Boolean) property.getValue();
                return b != null && b ? "Yes" : "No";
            }
        }
        return super.formatPropertyValue(rowId, colId, property);
    }
}
