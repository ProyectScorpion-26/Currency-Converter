package org.barajas.oscar.domain;

public class ExchangeRate {
    private Currency sourceCurrency;
    private Currency targetCurrency;
    private double rate;

    public ExchangeRate(Currency sourceCurrency, Currency targetCurrency, double rate) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.rate = rate;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public double getRate() {
        return rate;
    }
}
