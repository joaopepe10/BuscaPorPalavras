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
        this.url = url;
        this.termo = termo.trim();
    }

    public String validaUrl(String url){
        Pattern padrao = Pattern.compile("(^[https://]{0,8})");
        Matcher combinacao = padrao.matcher(url);
        if (!combinacao.find()){
            url = "https://" + url.trim();
        } else {
            url = url.replaceFirst("(^[https://]{0,8})", "https://").trim();
        }
        return url;
    }
    @Override
    public String removeTags() throws IOException{
        String urlValidada = getUrl();
       Document urlBuscada = Jsoup.connect(urlValidada).get();
       String textoUrl = urlBuscada.body().text();
       textoUrl = Jsoup.parse(textoUrl).text();
        return textoUrl;
    }

    public int contarOcorrencias(String texto, String palavra){
        Pattern padrao = Pattern.compile("(\\s|\\W)" + palavra + "(\\W|\\s)");
        Matcher combinacao = padrao.matcher(texto);
        int contador = 0;
        while (combinacao.find()){
            contador++;
        }
        return contador;
    }
    @Override
    public StringBuilder busca() throws IOException {
        String texto = this.removeTags();
        List<String> termos = new ArrayList<>();
        List<Integer> contadores = new ArrayList<>();
        String[] termoFatiado = getTermo().split("\\s");
        StringBuilder textoFormatado = new StringBuilder();

        for (String termo : termoFatiado){
            int contador = contarOcorrencias(texto, termo);
            termos.add(termo);
            contadores.add(contador);
            textoFormatado.append("\nPalavra [")
                          .append(termo)
                          .append("] encontrada ")
                          .append(contador).append(" vezes.");
        }

            return textoFormatado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo.trim();
    }
}
