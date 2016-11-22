/**
 * @author Vinayak More
 *
 * @date 19-Nov-2016
 */
package com.example.ui;

import java.io.Serializable;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class Greeter implements Serializable{
    
    private static final long serialVersionUID = 1574318952251325388L;

    public String sayHello(){
        return "Hii there, I m injected Here!!!!!";
    }
    

}
