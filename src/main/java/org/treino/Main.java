package org.treino;

import org.treino.busca_padrao.RemocaoDeTagsHtml;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
        RemocaoDeTagsHtml buscarUrl = new RemocaoDeTagsHtml();
        System.out.println(buscarUrl.removeTags());
    }
}