package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiToCurrenyConvertion {

    public ApiToCurrenyConvertion() {
    }

    public String start(String baseCurrency, String targetCurrency, String value) {
        try {
            String address = String.format("https://v6.exchangerate-api.com/v6/8bacb451f11c192221984038/pair/%s/%s/%s", baseCurrency, targetCurrency, value);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
