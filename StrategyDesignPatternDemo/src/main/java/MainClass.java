/**
 * @author Vinayak More.
 * @date 09-Aug-2016	
 */
package main.java;

import main.java.DuckImpl.ModelDuck;
import main.java.behaviour.flyImpl.FlyRocketPowered;

public class MainClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("MainClass.main()");
        Duck duck=new ModelDuck();
        duck.performFly();
        duck.performQuak();
        duck.display();
        duck.setFlyBehaviour(new FlyRocketPowered());
        duck.performFly();
        
        
    }

}
