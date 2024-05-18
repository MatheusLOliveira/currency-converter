package service;

import com.google.gson.Gson;
import models.CurrencyConvertion;

public class ConvertingToJsonCurrencyConvertion {

    private ApiToCurrenyConvertion apiToCurrenyConvertion;

    public ConvertingToJsonCurrencyConvertion(ApiToCurrenyConvertion apiToCurrenyConvertion) {
        this.apiToCurrenyConvertion = apiToCurrenyConvertion;
    }

    public CurrencyConvertion start(String baseCurrency, String targetCurrency, String value) {
        Gson gson = new Gson();

        return gson.fromJson(apiToCurrenyConvertion.start(baseCurrency, targetCurrency, value), CurrencyConvertion.class);
    }

}
