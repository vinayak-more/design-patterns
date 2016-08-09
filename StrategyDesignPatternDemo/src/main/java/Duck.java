/**
 * @author Vinayak More.
 * @date 09-Aug-2016
 */
package main.java;

import main.java.behaviour.FlyBehaviour;
import main.java.behaviour.QuackBehaviour;


public abstract class Duck {


    public FlyBehaviour flyBehaviour;
    public QuackBehaviour quackBehaviour;

    public Duck() {}

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuak() {
        quackBehaviour.quak();
    }

    public void swim() {
        System.out.println("Duck.swim()");
    }

    public abstract void display();
    
    public void setFlyBehaviour(FlyBehaviour flyBehaviour){
        this.flyBehaviour=flyBehaviour;
    }
    
    public void setQuackBehaviour(QuackBehaviour quackBehaviour){
        this.quackBehaviour=quackBehaviour;
    }

}
