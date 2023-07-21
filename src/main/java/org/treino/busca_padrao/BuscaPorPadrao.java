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
        //USADO O INICIO E FIM DE UMA TAG PARA FAZER O FATIAMENTO DA STRING
        String p1 = "<p>?";
        String p2 = "</p>?";

        Pattern padrao1 = Pattern.compile(p1);
        Pattern padrao2 = Pattern.compile(p2);

        Matcher combinacao1 = padrao1.matcher(textoUrl);
        Matcher combinacao2 = padrao2.matcher(textoUrl);

        System.out.println("EXPRECAO BUSCADA: (" + p1 +")(CONTEUDO)(" + p2 + ")");
        ArrayList<String> linhas = new ArrayList<>();

        while (combinacao1.find()&& combinacao2.find()){
            //AQUI FAZ O FATIAMENTO DA STRING DE ACORDO COM O INDICE ONDE TERMINA, ESSE SERA O INICIO, O PRIMEIRO PADRAO DE BUSC
            //E ONDE COMECA O SEGUNDO PADRAO E ONDE IRA FAZER O FATIAMENTO DA STRING, ESSE SERA O FIM
            linhas.add(textoUrl.substring(combinacao1.end(), combinacao2.start()));
        }
        for (String linha: linhas) {
            System.out.println(linha);
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaPorPadrao b = new BuscaPorPadrao();
        b.buscaPorCaracter();
    }
}
