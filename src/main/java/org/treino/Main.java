package org.treino;

import org.treino.buscar_dados_na_url.BuscaDados;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaDados busca = new BuscaDados();
        String regex = "jo";
        String texto = "joao, maria ,joana, marcos, jobovaldo, lucas, vitor";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("TEXTO: " + texto);
        System.out.println("INDICE: 0123456789");
        System.out.println("EXPRESSAO: " + matcher.pattern());
        System.out.println("POSICOES ENCONTRADAS: ");
        while (matcher.find()){
            System.out.println(matcher.start() + " ");
        }
    }
}