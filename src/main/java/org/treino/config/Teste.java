package org.treino.config;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Teste {

    public static void main(String[] args) throws IOException {


       /* String regex = "([AC]{2}\s)(.*?)([BAC]{3})";
        String textoBuscado = " AC " +
                " Joao " +
                " BAC " +
                " TB " +
                " TESTE " +
                " TA " +
                " AC " +
                " Pedro " +
                " BAC ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textoBuscado);

        while (matcher.find()){
            *//*System.out.println("Indice Inicio = [" + matcher.start() + "] Inidice Fim = [" + matcher.end() +
                    "] \nConteudo:\n{ \n\t" + matcher.group() +
                    "\n}");
            *//*
            listaDeLinhas.add(textoBuscado.substring(matcher.start() + 2,matcher.end() - 3));

        }
        System.out.println(listaDeLinhas.stream().toList());*/

       /* String parametro = "<p>?";
        Pattern padrao = Pattern.compile(parametro);
        Matcher buscaCombinacao = padrao.matcher(textoUrl);

        String parametro2 = "</p>?";
        Pattern padrao2 = Pattern.compile(parametro2);
        Matcher buscaCombinacao2 = padrao2.matcher(textoUrl);

        while (buscaCombinacao.find() && buscaCombinacao2.find()){
            *//*System.out.println("Indice Inicio = [" + buscaCombinacao.start() + "] Inidice Fim = [" + buscaCombinacao2.end() +
                    "] \nConteudo:\n{ \n\t" + buscaCombinacao.group() +
                    "\n}");*//*
            listaDeLinhas.add(textoUrl.substring(buscaCombinacao.end(), buscaCombinacao2.start()));
        }

        for (String linha:listaDeLinhas){
            System.out.println(linha);
        }*/
        /*String texto = " meu nome e joao <a> assfsd title=\"pedro\" </a> meu sobre nome e pires";

        // Expressão regular para encontrar o conteúdo entre as tags <a> e o atributo title
        String regex = "(<a>.*[=]{1})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        String novoTexto = "";
        while (matcher.find()){
            System.out.println(matcher.group(1));
            System.out.println("INICIO:" + matcher.start()+" FIM: " + matcher.end());
            //COM ESSE METODO EU CONSIGO PASSAR O FILTRO QUE EU DESEJO E QUANDO ENCONTRAR CONSIGO FAZER A SUBSTITUICAO POR ALGUM TEXTO!
            novoTexto += "\n" + texto.replaceFirst(regex, "");
        }

        System.out.println(novoTexto);*/

        Document document = Jsoup.connect("https://pt.wikipedia.org/wiki/Pirâmides_egípcias").get();
        //System.out.println(document.getElementsByTag("a"));


        // Conecta e obtém o documento HTML da URL
        Document urlBuscada = Jsoup.connect("https://pt.wikipedia.org/wiki/Pirâmides_egípcias").get();

        // Obtém todas as tags <p> e seus conteúdos
        Elements paragrafos = urlBuscada.getElementsByTag("p");

        // Transforma os parágrafos em um texto incluindo todas as tags
        String textoUrl = paragrafos.toString();

        // Retira as tags do texto para uma leitura melhor
        //textoUrl = textoUrl.replaceAll("<[^>]+>", "");

        // Troca o conteúdo da tag <a> somente pelo título
       // textoUrl = textoUrl.replaceAll("<a[^>]*>(.*?)</a>", "$1");

        // Retorna o texto resultante
        System.out.println(textoUrl);
    }
    }
