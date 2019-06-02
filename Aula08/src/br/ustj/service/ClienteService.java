package br.ustj.service;

import br.ustj.dao.ClienteDAO;
import br.ustj.model.Cliente;

public class ClienteService {
	ClienteDAO dao = new ClienteDAO();
	
	public int criar(Cliente to) {
		return dao.criar(to);
	}
	
	public void atualizar(Cliente to){
		dao.atualizar(to);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Cliente carregar(int id){
		return dao.carregar(id);
	}

}
