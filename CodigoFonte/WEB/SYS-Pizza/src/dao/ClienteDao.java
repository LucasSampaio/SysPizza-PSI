package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import managedBean.ClienteBean;
import negocio.Cliente;
import negocio.Usuario;

public class ClienteDao {
	
	
	//private Cliente cliente;
	private ClienteBean clienteBean;
	private List<Cliente> lista;
	//private Usuario usuario;
	private UsuarioDao usuarioDao;
	
	
	public String salvar(Cliente cliente, Usuario usuario){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(cliente);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		System.out.println(" Codigo :" +cliente.getCodigo());
		usuario.setCliente(cliente);
		System.out.println(" Passou do set");
		setUsuarioDao(new UsuarioDao());
		usuarioDao.salvar(usuario);
		System.out.println(" Passou do salvar cliente");
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



	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
