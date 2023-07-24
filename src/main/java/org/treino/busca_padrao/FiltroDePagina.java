package org.treino.busca_padrao;

import java.io.IOException;

public interface FiltroDePagina {

    String removeTags() throws IOException;

    String removeTags(String url) throws IOException;

    String busca(String termo, String urlBuscada) throws IOException;
}
