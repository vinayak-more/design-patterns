/**
 * @author Vinayak More.
 * @date 09-Aug-2016	
 */
package main.java;

import main.java.observer.CurrentConditionsDisplay;
import main.java.observer.ForecastDisplay;
import main.java.subject.WeatherData;

public class MainClass {

    public static void main(String[] args) {
        
        WeatherData weatherData=new WeatherData();
        
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay=new ForecastDisplay(weatherData);
        
        weatherData.setMeasurements(10, 20, 30);
       
    }

}
