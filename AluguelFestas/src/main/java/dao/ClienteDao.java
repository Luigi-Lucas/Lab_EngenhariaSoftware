package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Cliente;

public class ClienteDao implements IClienteDao{
	
	EntityManagerFactory mf = Persistence.createEntityManagerFactory ("HibJPA");

	@Override
	public Cliente pesquisar(String nomeCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Cliente cliente) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		if (cliente != null) {
			em.remove(cliente);
		}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Cliente> lista() {
		EntityManager em = mf.createEntityManager();
		List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
		em.close();
		return clientes;
	}

	@Override
	public List<Cliente> pesquisarPorNome(String nomeCliente) {
		EntityManager em = mf.createEntityManager();
		List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nomeCliente", Cliente.class)
				.setParameter("nome", "%" + nomeCliente + "%")
				.getResultList();
		em.close();
		return clientes;
	}
}
