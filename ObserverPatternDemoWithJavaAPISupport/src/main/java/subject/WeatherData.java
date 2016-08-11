/**
 * @author Vinayak More.
 * @date 10-Aug-2016
 */
package main.java.subject;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        super();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }
    private void measurementsChanged() {
        Map<String,Float> map=new HashMap<>();
        map.put("TEMPERATURE", temperature);
        map.put("HUMIDITY", humidity);
        map.put("PRESSURE", pressure);
        setChanged();
        notifyObservers(map);
    }
    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    public float getHumidity() {
        return humidity;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    public float getPressure() {
        return pressure;
    }
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
    
    

}
