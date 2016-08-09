/**
 * @author Vinayak More.
 * @date 09-Aug-2016	
 */
package main.java.behaviour.flyImpl;

import main.java.behaviour.FlyBehaviour;

public class FlyNoWay implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("NoFly.fly()");

    }

}
