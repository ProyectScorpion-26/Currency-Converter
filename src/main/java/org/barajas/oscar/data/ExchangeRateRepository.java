package org.barajas.oscar.data;

import org.barajas.oscar.domain.Currency;
import org.barajas.oscar.domain.ExchangeRate;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRateRepository {
    private Map<String, ExchangeRate> rates = new HashMap<>();

    public void addExchangeRate(ExchangeRate exchangeRate) {
        String key = generateKey(exchangeRate.getSourceCurrency().getCode(), exchangeRate.getTargetCurrency().getCode());
        rates.put(key, exchangeRate);
    }

    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        String key = generateKey(source.getCode(), target.getCode());
        return rates.get(key);
    }

    private String generateKey(String sourceCode, String targetCode) {
        return sourceCode + "_" + targetCode;
    }
}
