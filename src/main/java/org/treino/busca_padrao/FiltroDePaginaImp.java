package org.treino.busca_padrao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FiltroDePaginaImp implements FiltroDePagina {

    private String url;
    private String termo;

    public FiltroDePaginaImp() {

    }

    public FiltroDePaginaImp(String url, String termo) {
        if (url.contains("https://")){
            this.url = url.trim();
        } else if (url.contains("http://")) {
            this.url = url.replaceFirst("p", "ps");
        } else {
            this.url = "https://" + url.trim();
        }
        this.termo = termo.trim();
    }
    @Override
    public String removeTags() throws IOException{
        // CONNECT PEGA A URL E A TRANSFORMA EM UM TEXTO INCLUINDO TODAS AS TAGS
        // URL PADRAO
        Document urlBuscada = Jsoup.connect(getUrl()).get();

        // PASSADO COMO PARAMETRO A TAG QUE DESEJA OBTER O CONTEUDO
        String textoUrl = urlBuscada.body().text();
        /*
        * COM AUXILIO DO SITE https://regexr.com PARA FAZER AS EXPRESSOES REGULARES E VIZUALIZAR EM TEMPO REAL OQUE A EXPRESSAO SELECIONA
        * RETIRANDO AS TAGS DO TEXTO PARA UMA LEITURA MELHOR
        * FAZ A CAPTURA DO CONTEUDO DA TAG A E AGRUPO O TITLE E FAZ A TROCA DESSE CONTEUDO PELO GRUPO 1 QUE ESTA ENTRE PARENTESES
        */
        textoUrl = textoUrl.replaceAll("<a[^>]*>(.*?)</a>", "$1");
        textoUrl = textoUrl.replaceAll("<[^>]+>", "");

        return textoUrl;
    }
    @Override
    public StringBuilder busca() throws IOException {
        String texto = this.removeTags();
        List<String> termos = new ArrayList<>();
        List<Integer> contadores = new ArrayList<>();
        String[] termoFatiado = getTermo().split("\\s");
        StringBuilder textoFormatado = new StringBuilder();

        for (int i = 0; i < termoFatiado.length + 1; ++i) {
            int contador = 0;
                if (i == 0) {
                    termos.add(getTermo());
                    Pattern padrao = Pattern.compile("(\\s|\\W)" + termos.get(i) + "(\\W|\\s)");
                    Matcher combinacao = padrao.matcher(texto);
                    while (combinacao.find()) {
                        contador++;
                    }
                    contadores.add(contador);
                } else {
                    termos.add(termoFatiado[i-1]);
                    Pattern padrao = Pattern.compile("(\\s|\\W)" + termos.get(i) + "(\\W|\\s)");
                    Matcher combinacao = padrao.matcher(texto);
                    while (combinacao.find()) {
                        contador++;
                    }
                    contadores.add(contador);
                }
            textoFormatado.append("\nPalavra [").append(termos.get(i)).append("] encontrada ").append(contadores.get(i)).append(" vezes");
            }

            return textoFormatado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if ("https://".contains(url)){
            this.url = url.trim();
        }else {
            this.url = "https://" + url.trim();
        }
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo.trim();
    }
}
