package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocio.FormaPgt;

public class PagamentoDao {
	private FormaPgt formaPgt;
	private List<FormaPgt> lista;
	
	public List<FormaPgt> pesquisar(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		
		setLista(new ArrayList<FormaPgt>());
		String jpql ="select f from FormaPgt f";
		Query query = manager.createQuery(jpql);
		
		lista = query.getResultList();
		
		manager.close();
		factory.close();
		
		return lista;
	}
	
	

	public FormaPgt getFormaPgt() {
		return formaPgt;
	}

	public void setFormaPgt(FormaPgt formaPgt) {
		this.formaPgt = formaPgt;
	}

	public List<FormaPgt> getLista() {
		return lista;
	}

	public void setLista(List<FormaPgt> lista) {
		this.lista = lista;
	}

}
