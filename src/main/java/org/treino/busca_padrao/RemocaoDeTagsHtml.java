package org.treino.busca_padrao;

import java.io.IOException;

public interface RemocaoDeTagsHtml {

    String removeTags() throws IOException;

    String removeTags(String url) throws IOException;
}
