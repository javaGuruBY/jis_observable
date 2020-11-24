package by.jrr.myobservable.interfaces;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpRatesRequest {

    private double rur;
    private double usd;
    private double eur;
}
