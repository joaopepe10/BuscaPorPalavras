package org.treino.busca_padrao;

import org.treino.buscar_dados_na_url.BuscaDados;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscaPorPadrao {

    public void buscaPorCaracter() {
        String texto = "<p> joao e lindo </p>";

        //String parametro = "(?:[<]p[>])?(.*?)(?:[<][/]p[>])?";
        String parametro = "(<p>)(.*?)(</p>)";
        Pattern padrao = Pattern.compile(parametro);
        Matcher combinacao = padrao.matcher(texto);
        System.out.println("EXPRECAO BUSCADA: " + parametro);

        while (combinacao.find()) {
            String textoFormatado = combinacao.group();
            //System.out.print("INDICE:[" + combinacao.start() + "]={" + textoFormatado + "} ");
            System.out.println(combinacao.group(2));
        }

    }

    public static void main(String[] args) {
        BuscaPorPadrao b = new BuscaPorPadrao();
        b.buscaPorCaracter();
    }
}
