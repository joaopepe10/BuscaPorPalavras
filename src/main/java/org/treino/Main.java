package org.treino;

import org.treino.buscar_dados_na_url.BuscaDados;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaDados busca = new BuscaDados();
        System.out.println(busca.retornaDados());
    }
}