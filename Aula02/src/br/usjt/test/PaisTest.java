package br.usjt.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.usjt.dao.PaisDAO;
import br.usjt.model.Pais;


public class PaisTest {
	
	@Test
	public void testComMaisHabitantes() {
		PaisDAO dao = new PaisDAO();
		Pais p = dao.comMaisHabitantes();
		assertEquals("pais com mais habitantes", "Brasil", p.getNome());
	}

}
