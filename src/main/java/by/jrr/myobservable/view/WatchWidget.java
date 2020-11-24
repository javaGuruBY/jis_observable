package by.jrr.myobservable.view;

import by.jrr.myobservable.interfaces.HttpRatesRequest;
import by.jrr.myobservable.interfaces.Observer;
import by.jrr.myobservable.interfaces.Subject;
import lombok.Data;

@Data
public class WatchWidget implements InfoWidget, Observer {

    double usd;

    private Subject webScrapper;

    public WatchWidget(Subject webScrapper) {
        this.webScrapper = webScrapper;
        webScrapper.registerObserver(this);
    }

    @Override
    public void update(HttpRatesRequest request) {
        this.usd = request.getUsd();
        display();
    }

    public void display() {
        System.out.println("[@WatchWidget@] "+usd);
    }

    public void observeRates() {
        webScrapper.registerObserver(this);
    }

    public void stopObserve() {
        webScrapper.removeObserver(this);
    }

}
