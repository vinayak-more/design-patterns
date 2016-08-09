/**
 * @author Vinayak More.
 * @date 09-Aug-2016
 */
package main.java.subject;

import main.java.observer.Observer;

public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
