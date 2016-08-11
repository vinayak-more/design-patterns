/**
 * @author Vinayak More.
 * @date 10-Aug-2016
 */
package main.java.observer;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import main.java.weather.DisplayElements;

public class ForecastDisplay implements Observer, DisplayElements {

    private float humidity;
    private float pressure;
    private Map<String,Float> map;

    public ForecastDisplay(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void update(Observable o, Object arg) {
        this.map=(Map<String, Float>) arg;
        pressure=map.get("PRESSURE");
        humidity=map.get("HUMIDITY");
        display();
    }

    @Override
    public String toString() {
        return "ForecastDisplay [humidity=" + humidity + ", pressure=" + pressure + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(humidity);
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
        ForecastDisplay other = (ForecastDisplay) obj;
        if (Float.floatToIntBits(humidity) != Float.floatToIntBits(other.humidity))
            return false;
        if (Float.floatToIntBits(pressure) != Float.floatToIntBits(other.pressure))
            return false;
        return true;
    }
    
}
