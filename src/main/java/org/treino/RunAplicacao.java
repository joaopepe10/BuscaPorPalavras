package org.treino;

import org.treino.busca_padrao.FiltroDePaginaImp;


import java.io.IOException;
import java.util.Scanner;

public class RunAplicacao {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        try{
            System.out.print("Digite uma url:");
            String url = in.next();
            System.out.print("Digite uma palavra para buscar:");
            String palavra = in.next();
            FiltroDePaginaImp filtro = new FiltroDePaginaImp(url, palavra);
            System.out.println(filtro.busca());
            in.close();
        }catch (IOException e){
            System.out.println("Url invalida!");
        }

    }
}