package org.treino.busca_padrao;

import java.io.IOException;

public interface FiltroDePagina {

    String removeTags() throws IOException;
    StringBuilder busca() throws IOException;
    String validaUrl(String url);
}
