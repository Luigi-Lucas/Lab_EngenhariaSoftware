package controller;

import java.util.List;
import dao.ClienteDao;
import model.Cliente;

public class ClienteController {
	
    private ClienteDao clienteDao = new ClienteDao();
	
	public void inserirCliente (Cliente cliente){
		clienteDao.inserir(cliente);
	}
	
	public List<Cliente> pesquisarTodos (){
		return clienteDao.lista();
	}
	
	public List<Cliente> pesquisarUmCliente (String nome){
		return clienteDao.pesquisarPorNome(nome);
	}
	
	public void apagar (long id) {
		clienteDao.remover(id);
	}
}
