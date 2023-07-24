package org.treino.busca_padrao;

import java.io.IOException;

public interface FiltroDePagina {

    String removeTags() throws IOException;
    StringBuffer busca() throws IOException;
}
