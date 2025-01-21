package org.barajas.oscar;

import org.barajas.oscar.data.ExchangeRateRepository;
import org.barajas.oscar.facade.CurrencyExchangeFacade;
import org.barajas.oscar.http.CurrencyExchangeClient;
import org.barajas.oscar.presentation.App;

public class Main {
    public static void main(String[] args) {
        ExchangeRateRepository repository = new ExchangeRateRepository();
        CurrencyExchangeClient httpClient = new CurrencyExchangeClient();
        CurrencyExchangeFacade facade = new CurrencyExchangeFacade(repository, httpClient);
        App app = new App(facade);


        app.start();
    }
}
