package org.treino.config;

import org.treino.buscar_dados_na_url.BuscaDados;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teste {

    public static void main(String[] args) throws IOException {
        BuscaDados urlBuscada = new BuscaDados();
        Path path = Path.of("C:\\Users\\João Pedro\\Desktop\\AREA_DE_TRABALHO\\PROGRAMACAO\\PROJETOS\\JAVA\\TreinandoHTTP\\src\\main\\java\\org\\treino\\teste.txt");
        String textoUrl = Files.readString(path);

        List<String> listaDeLinhas = new ArrayList<>();

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

        String parametro = "<p>?";
        Pattern padrao = Pattern.compile(parametro);
        Matcher buscaCombinacao = padrao.matcher(textoUrl);

        String parametro2 = "</p>?";
        Pattern padrao2 = Pattern.compile(parametro2);
        Matcher buscaCombinacao2 = padrao2.matcher(textoUrl);

        while (buscaCombinacao.find() && buscaCombinacao2.find()){
            /*System.out.println("Indice Inicio = [" + buscaCombinacao.start() + "] Inidice Fim = [" + buscaCombinacao2.end() +
                    "] \nConteudo:\n{ \n\t" + buscaCombinacao.group() +
                    "\n}");*/
            listaDeLinhas.add(textoUrl.substring(buscaCombinacao.start() + 3, buscaCombinacao2.start()));
        }

        for (String linha:listaDeLinhas){
            System.out.println(linha);
        }

    }
}
