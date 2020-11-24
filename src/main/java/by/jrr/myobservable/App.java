package by.jrr.myobservable;

import by.jrr.myobservable.service.WebScrapper;
import by.jrr.myobservable.view.AndroidWidget;
import by.jrr.myobservable.view.InfoWidget;
import by.jrr.myobservable.view.SiteWidget;
import by.jrr.myobservable.view.WatchWidget;

public class App {
    public static void main(String[] args) {
        WebScrapper webScrapper = new WebScrapper();

        InfoWidget siteWidget = new SiteWidget(webScrapper);
        InfoWidget androidWidgetWidget = new AndroidWidget(webScrapper);
        InfoWidget watchWidget = new WatchWidget(webScrapper);

        webScrapper.getNewRates();
    }
}
