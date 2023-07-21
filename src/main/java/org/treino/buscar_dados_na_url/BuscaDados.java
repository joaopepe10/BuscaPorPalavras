package org.treino.buscar_dados_na_url;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class BuscaDados  {

    private final static int TIMEOUT = 10;

    public String retornaDados() throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://pt.wikipedia.org/wiki/Pirâmides_egípcias"))
                .timeout(Duration.ofSeconds(TIMEOUT))
                .build();

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(TIMEOUT))//DURACAO LIMITE QUE SERA FEITA A CONEXAO COM O SERVIDOR
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
