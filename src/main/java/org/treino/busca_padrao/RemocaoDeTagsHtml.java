package org.treino.busca_padrao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.treino.buscar_dados_na_url.BuscaDados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemocaoDeTagsHtml {

    private String url;

    public RemocaoDeTagsHtml() {
    }

    public RemocaoDeTagsHtml(String url) {
        this.url = url;
    }

    public String removeTags() throws IOException, InterruptedException {
        //CONNECT PEGA A URL E A TRANSFORMA EM UM TEXTO INCLUINDO TODAS AS TAGS
        Document urlBuscada = Jsoup.connect("https://pt.wikipedia.org/wiki/Pirâmides_egípcias").get();

        //PASSADO COMO PARAMETRO A TAG QUE DESEJA OBTER O CONTEUDO
        String textoUrl = urlBuscada.getElementsByTag("p").toString();

        return textoUrl;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
