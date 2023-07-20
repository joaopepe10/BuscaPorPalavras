package org.treino;

import org.treino.buscar_dados_na_url.BuscaDados;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaDados busca = new BuscaDados();
        var cont = 0;
        String regex = "\\w";
        String texto = "joao1, maria ,joana, marcos, jobovaldo, lucas, vitor 23-";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("TEXTO: " + texto);
        System.out.println("\nEXPRESSAO: " + matcher.pattern());
        System.out.println("POSICOES ENCONTRADAS: ");
        while (matcher.find()){
            System.out.print(matcher.start() + " ");
        }
    }
}