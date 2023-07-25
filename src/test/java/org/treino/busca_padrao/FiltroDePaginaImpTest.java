package org.treino.busca_padrao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiltroDePaginaImpTest {

    @Test
    void busca() {
        FiltroDePaginaImp busca = new FiltroDePaginaImp("ps://es.wikipedia.org/wiki/Pirámides_de_Egipto","bloques de piedra");
        Assertions.assertEquals(2, 2, "Espera se encontrar duas ocorrencias!");
    }

}