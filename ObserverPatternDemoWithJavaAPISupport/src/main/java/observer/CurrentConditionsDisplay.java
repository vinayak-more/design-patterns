/**
 * @author Vinayak More.
 * @date 10-Aug-2016	
 */
package main.java.observer;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import main.java.weather.DisplayElements;

public class CurrentConditionsDisplay implements Observer, DisplayElements {
    
    private float temperature;
    private float humidity;
    private float pressure;
    private Map<String,Float> map;

    
    public CurrentConditionsDisplay(Observable observable){
        observable.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        this.map=(Map<String, Float>) arg;
        temperature=map.get("TEMPERATURE");
        pressure=map.get("PRESSURE");
        humidity=map.get("HUMIDITY");
        display();
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CurrentConditionsDisplay [temperature=" + temperature + ", humidity=" + humidity + ", pressure="
                + pressure + "]";
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
        CurrentConditionsDisplay other = (CurrentConditionsDisplay) obj;
        if (Float.floatToIntBits(humidity) != Float.floatToIntBits(other.humidity))
            return false;
        if (Float.floatToIntBits(pressure) != Float.floatToIntBits(other.pressure))
            return false;
        if (Float.floatToIntBits(temperature) != Float.floatToIntBits(other.temperature))
            return false;
        return true;
    }
    
    

}
