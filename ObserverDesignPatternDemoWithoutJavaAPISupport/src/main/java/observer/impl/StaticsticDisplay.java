/**
 * @author Vinayak More.
 * @date 09-Aug-2016	
 */
package main.java.observer.impl;

import main.java.observer.Observer;
import main.java.subject.Subject;
import main.java.weather.DisplayElement;

public class StaticsticDisplay implements DisplayElement, Observer {

    private float temperature;
    private float humidity;
    private float pressure;
    
    public StaticsticDisplay(Subject subject){
        subject.registerObserver(this);
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        // TODO Auto-generated method stub
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "StaticsticDisplay [temperature=" + temperature + ", humidity=" + humidity + ", pressure=" + pressure
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(humidity);
        result = prime * result + Float.floatToIntBits(pressure);
        result = prime * result + Float.floatToIntBits(temperature);
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
        StaticsticDisplay other = (StaticsticDisplay) obj;
        if (Float.floatToIntBits(humidity) != Float.floatToIntBits(other.humidity))
            return false;
        if (Float.floatToIntBits(pressure) != Float.floatToIntBits(other.pressure))
            return false;
        if (Float.floatToIntBits(temperature) != Float.floatToIntBits(other.temperature))
            return false;
        return true;
    }

}
