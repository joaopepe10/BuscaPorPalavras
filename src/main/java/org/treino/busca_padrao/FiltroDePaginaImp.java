package org.treino.busca_padrao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class FiltroDePaginaImp implements FiltroDePagina {

    private String url;
    private String termo;

    public FiltroDePaginaImp() {

    }

    public FiltroDePaginaImp(String url, String termo) {
        this.url = url;
        this.termo = termo;
    }

    public String removeTags() throws IOException{
        // CONNECT PEGA A URL E A TRANSFORMA EM UM TEXTO INCLUINDO TODAS AS TAGS
        // URL PADRAO
        Document urlBuscada = Jsoup.connect(getUrl()).get();
        // PASSADO COMO PARAMETRO A TAG QUE DESEJA OBTER O CONTEUDO
        String textoUrl = urlBuscada.getElementsByTag("p").toString();

        // COM AUXILIO DO SITE https://regexr.com PARA FAZER AS EXPRESSOES REGULARES E VIZUALIZAR EM TEMPO REAL OQUE A EXPRESSAO SELECIONA
        // RETIRANDO AS TAGS DO TEXTO PARA UMA LEITURA MELHOR
        // FAZ A CAPTURA DO CONTEUDO DA TAG A E AGRUPO O TITLE E FAZ A TROCA DESSE CONTEUDO PELO GRUPO 1 QUE ESTA ENTRE PARENTESES
        textoUrl = textoUrl.replaceAll("<a[^>]*>(.*?)</a>", "$1");
        textoUrl = textoUrl.replaceAll("<[^>]+>", "");

        return textoUrl;
    }

    public String busca() throws IOException {

        // SEPARANDO CADA PALAVRA QUE TEM UM ESPACO ENTRE ELAS PARA FAZER A BUSCA POR TODAS
        String[] termos = getTermo().split("\s");

        //CONTADOR SERA ASSOCIADO A CADA TERMO, INCLUINDO O TERMO QUE ESTA COMO ARGUMENTO
        Integer[] contador = new Integer[termos.length + 1];
        String texto = this.removeTags();

        // FORMATANDO A RESPOSTA, MOSTRANDO TODAS AS BUSCAS POSSIVEIS!
        String respostaFormatada = termo;
        for (String te: termos){
            respostaFormatada += "\n" + te;
        }
        return respostaFormatada;
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
        this.termo = termo;
    }
}
