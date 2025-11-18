package com.oracle.exchangerate.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class ConectionApi {

    String serverAPI = "https://v6.exchangerate-api.com/v6/";
    String apiKey = "27968ef1c8bd6c91d7447518";
    String baseCode,
           targetCode,
           questionApi,
           consultApi;
    double amount;

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

   // function to create the url to use on the api call
    public ExchangeRateApiResponse createConsulChangeRateTotAPI( String base_code, String target_code, double amount_to_change ) {
        baseCode = base_code;
        targetCode = target_code;
        amount = amount_to_change;
        questionApi = "/pair/" + baseCode + "/" + targetCode + "/" + amount;
        consultApi = serverAPI + apiKey + questionApi;

        return ConectToApi(consultApi);
    }


    // function to send the request to the api a get the response
    private ExchangeRateApiResponse ConectToApi(String consultAPI) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(consultAPI))
                    .build();

            // CompletableFuture is used to make use of the asynchronous consult to api
            CompletableFuture<HttpResponse<String>> responseFuture = client
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString());

            CompletableFuture<String> jsonResponseFuture = responseFuture.thenApply(HttpResponse::body);
            String json = jsonResponseFuture.join(); // Wait for the future to complete and get the JSON

            // Convert the JSON into a record ExchangeRateApiResponse object
            return gson.fromJson(json, ExchangeRateApiResponse.class);

        } catch (Exception e) {
            System.out.println("Error al enviar la solicitud HTTP: " + e.getMessage());
        }
        return null;
    }
} // end ConectionApi class
