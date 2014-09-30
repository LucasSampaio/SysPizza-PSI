package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocio.Cliente;
import negocio.Usuario;

public class UsuarioDao {
	
	private List<Usuario> lista;
	
	
	
public String salvar(Usuario usuario){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		
		return "voltar";
	}

public String alterar(Usuario usuario){
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
	EntityManager manager = factory.createEntityManager();
	manager.getTransaction().begin();
	
	manager.merge(usuario);
	manager.getTransaction().commit();
	manager.close();
	factory.close();
	
	
	return "voltarMenu";
}

public List<Usuario> pesquisar(Usuario usuario){
	System.out.println("Passou Inicio");
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
	EntityManager manager = factory.createEntityManager();
	
	setLista(new ArrayList<Usuario>());
	
	StringBuffer sb = new StringBuffer(100);

	sb.append("select u from Usuario u where "+" u.login = '"+usuario.getLogin()+"' "+
	"and "+ " u.senha = '"+usuario.getSenha()+"'");
			
	Query query = manager.createQuery(sb.toString());
	
	lista = query.getResultList();
	
	manager.close();
	factory.close();
	

	
	return lista;
}

public List<Usuario> getLista() {
	return lista;
}

public void setLista(List<Usuario> lista) {
	this.lista = lista;
}

}
