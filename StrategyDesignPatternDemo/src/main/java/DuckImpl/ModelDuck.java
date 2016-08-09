/**
 * @author Vinayak More.
 * @date 09-Aug-2016
 */
package main.java.DuckImpl;

import main.java.Duck;
import main.java.behaviour.flyImpl.FlyNoWay;
import main.java.behaviour.quakImpl.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        super();
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        System.out.println("ModelDuck.display()");
    }

}
