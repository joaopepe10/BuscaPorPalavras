package org.treino;

import org.treino.buscar_dados_na_url.BuscaDados;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String regex = "0[xX][0-9a-f-A-F]";
       String texto = "12 0xfb1 22 0xff 29 0xfa";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(texto);

       while (matcher.find()){
           System.out.println("[INICIO/INDICE=" + matcher.start() + "][GRUPO=" + matcher.group()+"]");
       }

    }
}