package com.retro.vaadin.module.transaction.component;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author Vinayak More
 *
 * @date 01-May-2017
 */
public class SuggestItem {

    private final long itemId;
    private final String itemCaption;

    public SuggestItem(long itemId, String itemCaption) {
        super();
        this.itemId = itemId;
        this.itemCaption = itemCaption;
    }

    public long getItemId() {
        return itemId;
    }

    public String getItemCaption() {
        return itemCaption;
    }

    @Override
    public String toString() {
        return itemCaption;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }



}
