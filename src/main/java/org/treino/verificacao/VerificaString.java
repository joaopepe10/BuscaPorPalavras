package org.treino.verificacao;

public class VerificaString {
    public String verificadorDeUrl(String url){
        String teste = "https://es.wikipedia.org/wiki/Pirámides_de_Egipto";
        if ("https://".contains(url)){
            return url;
        }else {
            return "https://"+ url;
        }
    }
}
