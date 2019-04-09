package br.usjt.web.calculadorajava.teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.usjt.web.calculadorajava.model.Calculadora;

class CalculadoraTest {
	
	Calculadora calculadora;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSomar() {
		assertEquals(20, calculadora.somar(10, 10), "O método de somoma 10 + 10 deu errado");
	}
	
	@Test
	void testSubtrair() {
		assertTrue(12 == calculadora.subtrair(20, 8));
	}
	
	@Test
	void testMultiplicarNegativo() {
		assertEquals(20, calculadora.multiplicar(-4, -5), "O teste de multiplicar com valores" 
	+ "negativos falhou.");
	}
	
	@Test
	void testMultiplicarZerado() {
		assertEquals(0, calculadora.multiplicar(50, 0), "O teste de multiplicação com valor zerado" 
	+ "falhou");
	}
	@Test
	void testMultiplicarPositivo() {
		assertEquals(100, calculadora.multiplicar(20, 5), "O teste de multiplicação de valores positivos" 
	+ "deu errado");
	}
	
	@Test
	void testExcecao() {
		assertThrows(ArithmeticException.class, () -> {
			calculadora.dividir(20, 0);
		}, "O método dividir não gerou exceção");
	}

}
