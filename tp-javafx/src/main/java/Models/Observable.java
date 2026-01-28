package Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Observable {
    protected Set<Observer> observers = new HashSet<Observer>();

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyChanges(double newTemperature){
        for (Observer observer : observers) observer.update(newTemperature);
    }
}
