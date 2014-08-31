package br.com.cepep.bilheteria.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomaTest {

	@Test
	public void seEuSomar2Mais2OResultadoDeveSer4() {
		
		Soma soma = new Soma();
		int resultado = soma.calcular(2,2);
		System.out.println(resultado);
		assertEquals(4, resultado);
		
	}

}
