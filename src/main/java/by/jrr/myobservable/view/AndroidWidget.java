package by.jrr.myobservable.view;

import by.jrr.myobservable.interfaces.HttpRatesRequest;
import by.jrr.myobservable.interfaces.Observer;
import by.jrr.myobservable.interfaces.Subject;
import lombok.Data;

@Data
public class AndroidWidget implements InfoWidget, Observer {

    private double rur;
    private double usd;
    private double eur;

    private Subject webScrapper;

    public AndroidWidget(Subject webScrapper) {
        this.webScrapper = webScrapper;
        webScrapper.registerObserver(this);
    }

    @Override
    public void update(HttpRatesRequest request) {
        this.rur = request.getRur();
        this.usd = request.getEur();
        this.eur = request.getUsd();
        display();
    }

    public void display() {
        System.out.println("[AndroidWidget.by... says ...]usd + eur + rur -> " + usd +" "+ eur +" "+rur);
    }

    public void observeRates() {
        webScrapper.registerObserver(this);
    }

    public void stopObserve() {
        webScrapper.removeObserver(this);
    }
}
