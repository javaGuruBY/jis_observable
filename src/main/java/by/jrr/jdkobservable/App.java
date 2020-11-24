package by.jrr.jdkobservable;

import by.jrr.jdkobservable.service.WebScrapper;
import by.jrr.jdkobservable.view.AndroidWidget;
import by.jrr.jdkobservable.view.SiteWidget;
import by.jrr.jdkobservable.view.WatchWidget;

public class App {
    public static void main(String[] args) throws InterruptedException {
        WebScrapper webScrapper = new WebScrapper();

        new SiteWidget(webScrapper);
        new AndroidWidget(webScrapper);
        new WatchWidget(webScrapper);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            webScrapper.getNewRates();
            System.out.println();
        }
    }
}
