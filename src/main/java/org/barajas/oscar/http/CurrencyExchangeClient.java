package org.barajas.oscar.http;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CurrencyExchangeClient {
    private OkHttpClient client = new OkHttpClient();
    private static final List<String> CURRENCY_CODES = Arrays.asList(
            "USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD",
            "ARS", "COP", "BRL", "BOB", "PEN", "MXN", "CLP", "KRW", "INR", "ZAR"
    );

    public double getExchangeRate(String sourceCode, String targetCode) throws IOException {
        if (!isValidCode(sourceCode) || !isValidCode(targetCode)) {
            throw new IllegalArgumentException("Invalid currency code. Use one of the following: " + CURRENCY_CODES);
        }

        String url = "https://api.exchangerate-api.com/v4/latest/" + sourceCode;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Response error: " + response);
            }

            String jsonResponse = response.body().string();
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("rates");

            if (rates.has(targetCode)) {
                return rates.get(targetCode).getAsDouble();
            } else {
                throw new IOException("Exchange rate for " + targetCode + " is not available.");
            }
        }
    }

    private boolean isValidCode(String code) {
        return CURRENCY_CODES.contains(code);
    }
}
