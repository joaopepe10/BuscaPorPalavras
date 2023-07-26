package org.treino;

import org.treino.busca_padrao.FiltroDePaginaImp;


import java.io.IOException;
import java.util.Scanner;

public class RunAplicacao {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Digite uma url:");
            String url = in.next();

            in.nextLine();

            System.out.println("Digite uma palavra para buscar:");
            String palavra = in.nextLine();

            FiltroDePaginaImp filtro = new FiltroDePaginaImp(url, palavra);
            System.out.println(filtro.busca());
        }catch (IOException e){
            System.out.println("Url invalida!");
        }

    }
}