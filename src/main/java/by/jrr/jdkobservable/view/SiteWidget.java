package by.jrr.jdkobservable.view;

import by.jrr.jdkobservable.service.WebScrapper;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
public class SiteWidget implements Observer {
    double eur;

    public SiteWidget(Observable webScrapper) {
        webScrapper.addObserver(this);
    }

    @Override
    public void update(Observable webScrapper, Object request) {
        if (webScrapper instanceof WebScrapper) {
            WebScrapper webData = (WebScrapper) webScrapper;
            this.eur = webData.getUsd();
            display();
        }
    }

    public void display() {
        System.out.println("[@SiteWidget@] "+eur);
    }

}
