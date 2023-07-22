package org.treino.busca_padrao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.treino.buscar_dados_na_url.BuscaDados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscaPorPadrao {

    private String url;

    public BuscaPorPadrao() {
    }

    public BuscaPorPadrao(String url) {
        this.url = url;
    }

    public String buscaPorParagrafo() throws IOException, InterruptedException {
        Document urlBuscada = Jsoup.connect("https://pt.wikipedia.org/wiki/Pirâmides_egípcias").get();
        String textoUrl = urlBuscada.toString();
        //USADO O INICIO E FIM DE UMA TAG PARA FAZER O FATIAMENTO DA STRING
        String p1 = "<p>?";
        String p2 = "</p>?";

        Pattern padrao1 = Pattern.compile(p1);
        Pattern padrao2 = Pattern.compile(p2);

        Matcher combinacao1 = padrao1.matcher(textoUrl);
        Matcher combinacao2 = padrao2.matcher(textoUrl);

        //System.out.println("EXPRECAO BUSCADA: (" + p1 +")(CONTEUDO)(" + p2 + ")");
        ArrayList<String> linhas = new ArrayList<>();

        while (combinacao1.find() && combinacao2.find()){
            //AQUI FAZ O FATIAMENTO DA STRING DE ACORDO COM O INDICE ONDE TERMINA, ESSE SERA O INICIO, O PRIMEIRO PADRAO DE BUSC
            //E ONDE COMECA O SEGUNDO PADRAO E ONDE IRA FAZER O FATIAMENTO DA STRING, ESSE SERA O FIM
            linhas.add(textoUrl.substring(combinacao1.end(), combinacao2.start()));
        }
        String novoTexto = "";
        for (String linha: linhas) {
            novoTexto += "\n" + linha;
        }
        return novoTexto;
    }

    public String buscaPorParagrafo(String urlArg) throws IOException, InterruptedException {
        BuscaDados urlBuscada = new BuscaDados();
        String textoUrl = urlBuscada.retornaDados(urlArg);
        //USADO O INICIO E FIM DE UMA TAG PARA FAZER O FATIAMENTO DA STRING
        String p1 = "<p>?";
        String p2 = "</p>?";

        Pattern padrao1 = Pattern.compile(p1);
        Pattern padrao2 = Pattern.compile(p2);

        Matcher combinacao1 = padrao1.matcher(textoUrl);
        Matcher combinacao2 = padrao2.matcher(textoUrl);

        //System.out.println("EXPRECAO BUSCADA: (" + p1 +")(CONTEUDO)(" + p2 + ")");
        ArrayList<String> linhas = new ArrayList<>();

        while (combinacao1.find() && combinacao2.find()){
            //AQUI FAZ O FATIAMENTO DA STRING DE ACORDO COM O INDICE ONDE TERMINA, ESSE SERA O INICIO, O PRIMEIRO PADRAO DE BUSC
            //E ONDE COMECA O SEGUNDO PADRAO E ONDE IRA FAZER O FATIAMENTO DA STRING, ESSE SERA O FIM
            linhas.add(textoUrl.substring(combinacao1.end(), combinacao2.start()));
        }
        String novoTexto = "";
        for (String linha: linhas) {
            novoTexto += "\n" + linha;
        }
        return novoTexto;
    }

    public String buscaPorTitulo() throws IOException, InterruptedException {
        BuscaPorPadrao b = new BuscaPorPadrao("https://pt.wikipedia.org/wiki/Pirâmides_egípcias");
        String texto = b.buscaPorParagrafo();
        String regex = "(<a[^>]*?\\stitle\\s*=)(\\s*\")(.*?)\"[^>]*?>(.*?)(<\\/a>)";
        Pattern p1 = Pattern.compile(regex);
        Matcher combincacao = p1.matcher(texto);
        List<String> novoTexto = new ArrayList<>();

        while (combincacao.find()){
            novoTexto.add(combincacao.group());
        }
        String resposta = "";
        for (String l: novoTexto)
        resposta += "\n" + l;
        return resposta;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
