package by.jrr.jdkobservable.view;

import by.jrr.jdkobservable.service.WebScrapper;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
public class AndroidWidget implements Observer {

    private double rur;
    private double usd;
    private double eur;

    public AndroidWidget(Observable webScrapper) {
        webScrapper.addObserver(this);
    }

    @Override
    public void update(Observable webScrapper, Object request) {
        if (webScrapper instanceof WebScrapper) {
            WebScrapper webData = (WebScrapper) webScrapper;
            this.rur = webData.getRur();
            this.usd = webData.getEur();
            this.eur = webData.getUsd();
            display();
        }
    }

    public void display() {
        System.out.println("[AndroidWidget.by... says ...]usd + eur + rur -> " + usd +" "+ eur +" "+rur);
    }
}
