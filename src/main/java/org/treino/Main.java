package org.treino;

import org.treino.busca_padrao.RemocaoDeTagsHtmlImp;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
        RemocaoDeTagsHtmlImp buscarUrl = new RemocaoDeTagsHtmlImp();
        System.out.println(buscarUrl.removeTags("http://www.sillion.com.br/blog/?p=1760&rdst_srcid=2893878"));
    }
}