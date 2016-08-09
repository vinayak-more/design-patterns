/**
 * @author Vinayak More.
 * @date 09-Aug-2016
 */
package main.java.observer.impl;

import main.java.observer.Observer;
import main.java.subject.Subject;
import main.java.weather.DisplayElement;

public class ThirdPartyDisplay implements DisplayElement, Observer {

    private float pressure;

    public ThirdPartyDisplay(Subject subject) {
        subject.registerObserver(this);

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        // TODO Auto-generated method stub
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(pressure);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ThirdPartyDisplay other = (ThirdPartyDisplay) obj;
        if (Float.floatToIntBits(pressure) != Float.floatToIntBits(other.pressure))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ThirdPartyDisplay [pressure=" + pressure + "]";
    }

}
