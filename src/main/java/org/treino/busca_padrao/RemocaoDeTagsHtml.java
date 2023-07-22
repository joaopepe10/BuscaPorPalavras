package org.treino.busca_padrao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        // CONNECT PEGA A URL E A TRANSFORMA EM UM TEXTO INCLUINDO TODAS AS TAGS
        Document urlBuscada = Jsoup.connect("https://pt.wikipedia.org/wiki/Pirâmides_egípcias").get();
        // PASSADO COMO PARAMETRO A TAG QUE DESEJA OBTER O CONTEUDO
        String textoUrl = urlBuscada.getElementsByTag("p").toString();

        // COM AUXILIO DO SITE https://regexr.com PARA FAZER AS EXPRESSOES REGULARES E VIZUALIZAR EM TEMPO REAL OQUE A EXPRESSAO SELECIONA
        // RETIRANDO AS TAGS DO TEXTO PARA UMA LEITURA MELHOR
        // FAZ A CAPTURA DO CONTEUDO DA TAG A E AGRUPO O TITLE E FAZ A TROCA DESSE CONTEUDO PELO GRUPO 1 QUE ESTA ENTRE PARENTESES
        textoUrl = textoUrl.replaceAll("<a[^>]*>(.*?)</a>", "$1");
        textoUrl = textoUrl.replaceAll("<[^>]+>", "");

        //TROCA DO CONTEUDO DA TAG <a SOMENTE PELO TITULO


        return textoUrl;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
