package org.treino.busca_padrao;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teste {
    public static void main(String[] args) throws IOException {
        String termo = "bloques de piedra";
        String[] termos = termo.split("\s");
        String url = "https://es.wikipedia.org/wiki/Pirámides_de_Egipto";
        FiltroDePaginaImp busca = new FiltroDePaginaImp(url, termo);
        int[] contador = new int[termos.length + 1];
        String txt = busca.removeTags();
        String regex = termo;


        boolean validacao = true;
        for (int i = 0; i < termos.length ; ++i ){
            if (i != 0){
                Pattern padrao = Pattern.compile(termos[i]);
                Matcher combinacao = padrao.matcher(txt);
                while (combinacao.find()){
                    contador[i] += 1 + combinacao.groupCount();
                }
            }
            if(i == 0){
                Pattern padrao = Pattern.compile(termo);
                Matcher combinacao = padrao.matcher(txt);
                while (combinacao.find()){
                    contador[i] += 1 + combinacao.groupCount();
                }
            }
        }
    }
}
