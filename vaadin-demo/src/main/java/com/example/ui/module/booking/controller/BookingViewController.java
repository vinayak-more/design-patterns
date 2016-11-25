/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.example.ui.module.booking.controller;

import org.springframework.context.event.EventListener;

import com.example.common.uihelper.view.AbstractController;
import com.example.ui.module.booking.event.TestEvent;
import com.example.ui.module.booking.view.BookingView;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class BookingViewController extends AbstractController<BookingView> {

    @Override
    public void onViewEnter() {
        System.out.println("BookingViewController.onViewEnter()");
    }

    @EventListener
    public void onEvent(TestEvent event){
        System.out.println("BookingViewController.onEvent()" + event.getStr());
    }
    
}
