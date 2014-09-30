package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocio.Cliente;
import negocio.Item;

public class ItemDao {
	
	private Item item;
	private List<Item> lista;
	
	
	public String salvar(Item item){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(item);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		return "voltar";
	}
	
	public String alterar(Item item){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.merge(item);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		return "voltar";
	}
	
	
	
	
	
	
	
	
	
	public Item pesquisarSaborPorCodigo(Integer codigo){
		System.out.println("Passou Inicio");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		
		setLista(new ArrayList<Item>());
		String sql = new String();		
		
		sql = "select i from Item i where i.codigo = "+codigo;		
		
		Query query = manager.createQuery(sql);
		
		lista = query.getResultList();
		
		manager.close();
		factory.close();
		
		//setItem(new Item());
		for(Item i: lista){
			
			item = i; 
			 
		}
	
		
		return item;
	}
	
	
	
	
	
	
	
	
	public List<Item> pesquisarSabor(Item item){
		System.out.println("Passou Inicio");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		
		setLista(new ArrayList<Item>());
		
		StringBuffer sb = new StringBuffer(100);
		
		sb.append("select i from Item i where i.tipo = 1 ");
		String condicao= " and ";
		
		if(item.getDescricao()!=""){
			System.out.println("passou do primeiro");
			sb.append(condicao +"i.descricao = '");
			sb.append(item.getDescricao()+"'");
			sb.append(" ");
			condicao = " and ";
		}
		
		if(item.getCodigo()!=0){
			System.out.println("passou do segundo");
			sb.append(condicao + " i.codigo = ");
			sb.append(item.getCodigo());
			sb.append(" ");
			condicao = " and ";
			
		}
		
		
		Query query = manager.createQuery(sb.toString());
		
		lista = query.getResultList();
		
		manager.close();
		factory.close();
		
	
		
		return lista;
	}
	
	
	
	
	public List<Item> pesquisarBebida(Item item){
		System.out.println("Passou Inicio");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		
		setLista(new ArrayList<Item>());
		
		StringBuffer sb = new StringBuffer(100);
		
		sb.append("select i from Item i where i.tipo = 2");
		String condicao= " and ";
		
		if(item.getDescricao()!=""){
			System.out.println("passou do primeiro");
			sb.append(condicao +"i.descricao = '");
			sb.append(item.getDescricao()+"'");
			sb.append(" ");
			condicao = " and ";
		}
		
		if(item.getCodigo()!=0){
			System.out.println("passou do segundo");
			sb.append(condicao + " i.codigo = ");
			sb.append(item.getCodigo());
			sb.append(" ");
			condicao = " and ";
			
		}
		
		
		Query query = manager.createQuery(sb.toString());
		
		lista = query.getResultList();
		
		manager.close();
		factory.close();
		
	
		
		return lista;
	}
	
	
	
	
	public List<Item> pesquisarSanduiche(Item item){
		System.out.println("Passou Inicio");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		
		setLista(new ArrayList<Item>());
		
		StringBuffer sb = new StringBuffer(100);
		
		sb.append("select i from Item i where i.tipo = 3");
		String condicao= " and ";
		
		if(item.getDescricao()!=""){
			System.out.println("passou do primeiro");
			sb.append(condicao +"i.descricao = '");
			sb.append(item.getDescricao()+"'");
			sb.append(" ");
			condicao = " and ";
		}
		
		if(item.getCodigo()!=0){
			System.out.println("passou do segundo");
			sb.append(condicao + " i.codigo = ");
			sb.append(item.getCodigo());
			sb.append(" ");
			condicao = " and ";
			
		}
		
		
		Query query = manager.createQuery(sb.toString());
		
		lista = query.getResultList();
		
		manager.close();
		factory.close();
		
	
		
		return lista;
	}
	
	
	
	public List<Item> pesquisarDoce(Item item){
		System.out.println("Passou Inicio");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		
		setLista(new ArrayList<Item>());
		
		StringBuffer sb = new StringBuffer(100);
		
		sb.append("select i from Item i where i.tipo = 4");
		String condicao= " and ";
		
		if(item.getDescricao()!=""){
			System.out.println("passou do primeiro");
			sb.append(condicao +"i.descricao = '");
			sb.append(item.getDescricao()+"'");
			sb.append(" ");
			condicao = " and ";
		}
		
		if(item.getCodigo()!=0){
			System.out.println("passou do segundo");
			sb.append(condicao + " i.codigo = ");
			sb.append(item.getCodigo());
			sb.append(" ");
			condicao = " and ";
			
		}
		
		
		Query query = manager.createQuery(sb.toString());
		
		lista = query.getResultList();
		
		manager.close();
		factory.close();
		
	
		
		return lista;
	}
	
	
	

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}



	public List<Item> getLista() {
		return lista;
	}



	public void setLista(List<Item> lista) {
		this.lista = lista;
	}

}
