package br.usjt.service;

import br.usjt.model.*;
import br.usjt.dao.*;;


public class PaisService {
	PaisDAO dao = new PaisDAO();
	
	public void criar(Pais pais) {
		dao.criar(pais);
	}
	
	public void atualizar(Pais pais){
		dao.atualizar(pais);
	}
	
	public void excluir(Pais p){
		dao.excluir(p);
	}
	
	public Pais carregar(int id){
		return dao.carregar(id);
	}

}