package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Pais;
import service.PaisService;

//TEM QUE FAZER
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais, pais2;
	PaisService paisService;
	static int id = 18;
	
	@Before
	public void setUp() {
		System.out.println("Preparando");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("China");
		pais.setPopulacao(1379302771);
		pais.setArea(9596961);
		pais2 = new Pais();
		pais2.setId(id);
		pais2.setNome("China");
		pais2.setPopulacao(1379302771);
		pais2.setArea(9596961);
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(pais2);
		System.out.println(id);
	}
	
	@Test
	public void test00Read() {
		System.out.println("Read");
		Pais fixture = new Pais();
		fixture.setId(4);
		fixture.setNome("Japão");
		fixture.setPopulacao(125209603);
		fixture.setArea(377972);
		PaisService newService = new PaisService();
		Pais newPais = newService.carregar(fixture.getId());
		assertEquals("Testa o Read", newPais, fixture);
	}
	
	@Test
	public void test01Create() {
		System.out.println("Create");
		id = paisService.criar(pais);
		System.out.println(id);
		assertEquals("Teste do create", pais, pais2);
		System.out.println(pais);
		System.out.println(pais2);
		System.out.println(id);
	}
	
	@Test
	public void test02Update() {
		System.out.println("Update");
		pais.setPopulacao(999999999);
		pais2.setPopulacao(999999999);		
		paisService.atualizar(pais);
		pais = paisService.carregar(pais.getId());
		assertEquals("Teste do Update", pais, pais2);
	}
	
	@Test
	public void test03Delete() {
		System.out.println("Delete");
		pais2.setId(-1);
		pais2.setNome(null);
		pais2.setPopulacao(0);
		pais2.setArea(0);
		paisService.excluir(id);
		pais = paisService.carregar(id);
		assertEquals("Teste do Delete", pais, pais2);
	}
}
