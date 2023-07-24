package org.treino.busca_padrao;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teste {
    public static void main(String[] args) throws IOException {
        String termo = "bloques de piedra";
        String[] termos = new String[termo.split("\\s").length + 1];
        String[] t = termo.split("\\s");
        for (int i = 0; i< termos.length;++i){
            if(i == 0){
                termos[i] = termo.trim();
            }else {
                termos[i] = t[i-1].trim();
            }
        }

        String url = "https://pt.wikipedia.org/wiki/Albert_Einstein";
        FiltroDePaginaImp busca = new FiltroDePaginaImp(url, termo);
        int[] contadores = new int[termos.length];
        String txt = busca.removeTags();

        //
        for (int i = 0; i < termos.length ; ++i ){
            Pattern padrao = Pattern.compile("(\\s|\\W)" + termos[i] + "(\\W|\\s)");
            Matcher combinacao = padrao.matcher(txt);
            while (combinacao.find()){
                contadores[i] += 1;
            }
        }
        for (int i = 0; i < termos.length ; ++i){
            System.out.println("Palavra [" + termos[i] + "] encontrada " + contadores[i] + " vezes!");
        }
    }
}
