package by.jrr.myobservable.view;

import by.jrr.myobservable.interfaces.HttpRatesRequest;
import by.jrr.myobservable.interfaces.Observer;
import by.jrr.myobservable.interfaces.Subject;
import lombok.Data;

@Data
public class SiteWidget implements InfoWidget, Observer {
    double eur;

    private Subject webScrapper;

    public SiteWidget(Subject webScrapper) {
        this.webScrapper = webScrapper;
        webScrapper.registerObserver(this);
    }

    @Override
    public void update(HttpRatesRequest request) {
        this.eur = request.getEur();
        display();
    }

    public void display() {
        System.out.println("[@SiteWidget@] "+eur);
    }

    public void observeRates() {
        webScrapper.registerObserver(this);
    }

    public void stopObserve() {
        webScrapper.removeObserver(this);
    }
}
