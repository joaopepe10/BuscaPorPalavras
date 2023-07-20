package org.treino;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://pt.wikipedia.org/wiki/Pirâmides_egípcias"))
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

    }
}