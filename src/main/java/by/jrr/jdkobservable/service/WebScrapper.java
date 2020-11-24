package by.jrr.jdkobservable.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WebScrapper extends Observable {

    private double rur;
    private double usd;
    private double eur;

    public void getNewRates() {
        this.rur = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));
        this.usd = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));
        this.eur = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));

        this.ratesUpdated();
    }

    private void ratesUpdated() {
        setChanged();
        notifyObservers();
    }
}
