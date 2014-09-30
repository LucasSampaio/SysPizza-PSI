package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import managedBean.ClienteBean;
import negocio.Cliente;

public class ClienteDao {
	
	
	private Cliente cliente;
	private ClienteBean clienteBean;
	private List<Cliente> lista;
	
	
	public String salvar(Cliente cliente){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(cliente);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		
		System.out.println(" Codigo :" +cliente.getCodigo());
		
		return "voltar";
	}
	
	public String alterar(Cliente cliente){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.merge(cliente);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		
		System.out.println(" Codigo :" +cliente.getCodigo());
		
		return "voltar";
	}
	
	
	public List<Cliente> pesquisar(Cliente cliente){
		System.out.println("Passou Inicio");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		
		setLista(new ArrayList<Cliente>());
		
		StringBuffer sb = new StringBuffer(100);
		
		sb.append("select c from Cliente c ");
		String condicao= " where ";
		
		if(cliente.getNome()!=""){
			System.out.println("passou do primeiro");
			sb.append(condicao +"c.nome = '");
			sb.append(cliente.getNome()+"'");
			sb.append(" ");
			condicao = " and ";
		}
		
		if(cliente.getCpf()!=""){
			System.out.println("passou do segundo");
			sb.append(condicao + " c.cpf = ");
			sb.append(cliente.getCpf());
			sb.append(" ");
			condicao = " and ";
			
		}
		
		
		Query query = manager.createQuery(sb.toString());
		
		lista = query.getResultList();
		
		manager.close();
		factory.close();
		
	
		
		return lista;
	}
	
	
	
	
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public ClienteBean getClienteBean() {
		return clienteBean;
	}




	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

}
