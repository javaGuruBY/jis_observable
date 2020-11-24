package by.jrr.jdkobservable.view;


import by.jrr.jdkobservable.service.WebScrapper;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
public class WatchWidget implements Observer {

    double usd;

    public WatchWidget(Observable webScrapper) {
        webScrapper.addObserver(this);
    }

    @Override
    public void update(Observable webScrapper, Object request) {
        if (webScrapper instanceof WebScrapper) {
            WebScrapper webData = (WebScrapper) webScrapper;
            this.usd = webData.getUsd();
            display();
        }
    }

    public void display() {
        System.out.println("[@WatchWidget@] "+usd);
    }
}
