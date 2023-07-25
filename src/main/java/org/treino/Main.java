package org.treino;

import org.treino.busca_padrao.FiltroDePaginaImp;
import org.treino.verificacao.VerificaString;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        String termo = "bloques de piedra";
        String url = "es.wikipedia.org/wiki/Pirámides_de_Egipto";
        FiltroDePaginaImp filtro = new FiltroDePaginaImp(url, termo);
       // System.out.println(filtro.busca());
        VerificaString verificaUrl = new VerificaString();
        System.out.println(verificaUrl.verificadorDeUrl(url));
    }
}