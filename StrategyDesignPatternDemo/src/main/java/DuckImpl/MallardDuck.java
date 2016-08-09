/**
 * @author Vinayak More.
 * @date 09-Aug-2016	
 */
package main.java.DuckImpl;

import main.java.Duck;
import main.java.behaviour.flyImpl.FlyWithWings;
import main.java.behaviour.quakImpl.Quack;

/**
 * @author infibeam
 *
 */
public class MallardDuck extends Duck {
    
    

    public MallardDuck() {
        super();
       flyBehaviour=new FlyWithWings();
       quackBehaviour=new Quack();
    }

    @Override
    public void display() {
        System.out.println("MallardDuck.display()");
    }

}
