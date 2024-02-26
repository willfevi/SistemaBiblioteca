package br.cefet.sisbiblioteca.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import br.cefet.sisbiblioteca.model.Livro;

public class AplicaDescontoTeste {
   
	@Test
    public void testAplicarDesconto() {
        Livro livro = new Livro();
        livro.setValor(100.0f); 

        Float valorComDesconto = livro.aplicarDesconto();

        assertEquals(90.0f, valorComDesconto, 0.01); 
	}

    @Test
    public void testAplicarDescontoComValorNulo() {
        Livro livro = new Livro();
        livro.setValor(null);

        Float valorComDesconto = livro.aplicarDesconto();

        assertNull(valorComDesconto);
    }

}
