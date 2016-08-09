/**
 * @author Vinayak More.
 * @date 09-Aug-2016	
 */
package main.java;

import main.java.observer.impl.CurrentConditions;
import main.java.observer.impl.ForecastDisplay;
import main.java.observer.impl.StaticsticDisplay;
import main.java.observer.impl.ThirdPartyDisplay;
import main.java.subject.impl.WeatherData;

public class MainClass {

    public static void main(String[] args) {
        //init Subject
        WeatherData weatherData=new WeatherData();
        
        //Init observers
        CurrentConditions currentDisplay=new CurrentConditions(weatherData);
        ForecastDisplay forecastDisplay=new ForecastDisplay(weatherData);
        StaticsticDisplay staticsticDisplay=new StaticsticDisplay(weatherData);
        ThirdPartyDisplay thirdPartyDisplay=new ThirdPartyDisplay(weatherData);
        
        weatherData.setMeasurements(10, 20, 30);
        
    }

}
