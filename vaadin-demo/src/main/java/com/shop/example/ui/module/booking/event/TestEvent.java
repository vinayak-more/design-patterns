/**
 * @author Vinayak More
 *
 * @date 24-Nov-2016
 */
package com.shop.example.ui.module.booking.event;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {
    
    private String str;
    private static final long serialVersionUID = 1L;

    public TestEvent(String string) {
        super(string);
        str=string;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


}
