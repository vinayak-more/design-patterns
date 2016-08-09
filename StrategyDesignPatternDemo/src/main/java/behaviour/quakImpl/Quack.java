/**
 * @author Vinayak More.
 * @date 09-Aug-2016	
 */
package main.java.behaviour.quakImpl;

import main.java.behaviour.QuackBehaviour;
public class Quack implements QuackBehaviour {

    @Override
    public void quak() {
        System.out.println("Quack.quak()");
    }

}
