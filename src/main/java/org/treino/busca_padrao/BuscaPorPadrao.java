package org.treino.busca_padrao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscaPorPadrao {

    public String buscaPorCaracter(String texto, String parametroBusca){
        Pattern padrao = Pattern.compile(parametroBusca);
        Matcher combinacao = padrao.matcher(texto);
        return;
    }
}
