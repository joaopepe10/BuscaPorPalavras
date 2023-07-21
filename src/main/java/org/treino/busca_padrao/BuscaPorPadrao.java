package org.treino.busca_padrao;

import org.treino.buscar_dados_na_url.BuscaDados;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscaPorPadrao {

    public void buscaPorCaracter() throws IOException, InterruptedException {
        BuscaDados urlBuscada = new BuscaDados();
        Path path = Path.of("C:\\Users\\João Pedro\\Desktop\\AREA_DE_TRABALHO\\PROGRAMACAO\\PROJETOS\\JAVA\\TreinandoHTTP\\src\\main\\java\\org\\treino\\teste.txt");
        String textoUrl = Files.readString(path);
        /*String texto = "<p> joao </p>" +
                "teste" +
                "<p> pedro </p>";*/

        String parametro = "(<p>)(.*?)(</p>)";
        Pattern padrao = Pattern.compile(parametro);
        Matcher combinacao = padrao.matcher(textoUrl);
        System.out.println("EXPRECAO BUSCADA: " + parametro);
        ArrayList<String> linhas = new ArrayList<>();
        var cont = 0;
        while (combinacao.find()){
            if (combinacao.group() == "<p>" || combinacao.group() == "</p>"){
            }else {
                linhas.add(combinacao.group());
            }
        }

        /*while (combinacao.find()) {
            String textoFormatado = combinacao.group();
            System.out.print("INDICE:[" + combinacao.start() + "]={" + textoFormatado + "} ");
        }*/

        for (String linha: linhas) {
            System.out.println(linha);
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaPorPadrao b = new BuscaPorPadrao();
        b.buscaPorCaracter();
    }
}
