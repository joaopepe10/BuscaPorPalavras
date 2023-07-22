package org.treino.busca_padrao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
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

        String regex = "<p>";
        Pattern padrao = Pattern.compile(regex);
        Matcher combinacao = padrao.matcher(textoUrl);

        // COM AUXILIO DO SITE https://regexr.com PARA FAZER AS EXPRESSOES REGULARES E VIZUALIZAR EM TEMPO REAL OQUE A EXPRESSAO SELECIONA
        //RETIRANDO AS TAGS DO TEXTO PARA UMA LEITURA MELHOR
        textoUrl = textoUrl.replaceAll("<p|>", "");
        textoUrl = textoUrl.replaceAll("</p|>", "");
        textoUrl = textoUrl.replaceAll("<b|>", "");
        textoUrl = textoUrl.replaceAll("</b|>", "");
        //FAZ A RETIRADA DA TAG CLASS
        textoUrl = textoUrl.replaceFirst("(^\\s|class)(.*?)(</span)+\\D", "");



        //COM ESSE REGEX EU CONSIGO PEGAR O CONTEUDO DA TAG <a ATE TITLE E FACO A SUBSTITUICAO POR UM ESPACO VAZIO, DIVIDINDO PARA CONQUISTAR
        textoUrl = textoUrl.replaceAll("<a(.*?)title(.*?[$\"]?)(.*?)(\")", "");
        return textoUrl;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
