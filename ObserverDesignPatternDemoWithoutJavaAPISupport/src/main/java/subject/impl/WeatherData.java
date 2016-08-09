/**
 * @author Vinayak More.
 * @date 09-Aug-2016	
 */
package main.java.subject.impl;

import java.util.ArrayList;
import java.util.List;

import main.java.observer.Observer;
import main.java.subject.Subject;

public class WeatherData implements Subject {
    
    private List<Observer> Observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    

    public WeatherData() {
        super();
       Observers=new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        Observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        Observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:Observers){
            observer.update(temperature, humidity, pressure);
        }
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }

    public void measurementsChanged(){
        notifyObservers();
    }
}
