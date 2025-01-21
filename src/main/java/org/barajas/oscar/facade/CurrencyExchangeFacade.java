package org.barajas.oscar.facade;

import org.barajas.oscar.data.ExchangeRateRepository;
import org.barajas.oscar.domain.Currency;
import org.barajas.oscar.domain.ExchangeRate;
import org.barajas.oscar.http.CurrencyExchangeClient;

import java.io.IOException;

public class CurrencyExchangeFacade {
    private final ExchangeRateRepository repository;
    private final CurrencyExchangeClient httpClient;

    public CurrencyExchangeFacade(ExchangeRateRepository repository, CurrencyExchangeClient httpClient) {
        this.repository = repository;
        this.httpClient = httpClient;
    }

    public double convertCurrency(String sourceCode, String targetCode, double amount) throws IOException {
        Currency source = new Currency(sourceCode, "");
        Currency target = new Currency(targetCode, "");
        ExchangeRate exchangeRate = repository.getExchangeRate(source, target);

        if (exchangeRate == null) {
            double rate = httpClient.getExchangeRate(sourceCode, targetCode);
            exchangeRate = new ExchangeRate(source, target, rate);
            repository.addExchangeRate(exchangeRate);
        }

        return amount * exchangeRate.getRate();
    }
}
