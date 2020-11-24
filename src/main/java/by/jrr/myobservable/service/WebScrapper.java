package by.jrr.myobservable.service;

import by.jrr.myobservable.interfaces.HttpRatesRequest;
import by.jrr.myobservable.interfaces.Observer;
import by.jrr.myobservable.interfaces.Subject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@NoArgsConstructor
public class WebScrapper implements Subject {

    public Set<Observer> observers = new HashSet<>();

    private double rur;
    private double usd;
    private double eur;

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(new HttpRatesRequest(rur, usd, eur)));
    }

    public void getNewRates() {
        this.rur = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));
        this.usd = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));
        this.eur = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));

        this.ratesUpdated();
    }

    private void ratesUpdated() {
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}
