package org.treino.busca_padrao;

import java.io.IOException;

public interface FiltroDePagina {

    String removeTags() throws IOException;
    String busca() throws IOException;
}
