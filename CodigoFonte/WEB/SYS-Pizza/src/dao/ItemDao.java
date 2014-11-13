package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocio.Cliente;
import negocio.Compra;
import negocio.Item;
import negocio.Pedido;

public class ItemDao {
	
	private Item item;
	private List<Item> lista;
	private List<Pedido> listaPedido;
	private Pedido pedido;
	private Compra compra;
	
	
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
	
	public String salvarPedidoCompra(List<Compra> listaCompra, Pedido pedido, Compra compra){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		
		manager.persist(pedido);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		for(Compra c: listaCompra){
			
			factory = Persistence.createEntityManagerFactory("novo");
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			
			c.setPedido(pedido);
			manager.persist(c);
			manager.getTransaction().commit();
			manager.close();
			factory.close();
			
		}
		
		
		return "confirmarPedido";
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
	
	
	public String baixarPedido(Pedido pedido){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.merge(pedido);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		
		
		return"nada";
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
	
 public Pedido pesquisarPedidoPorCodigo(Integer codigo){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		
		setListaPedido(new ArrayList<Pedido>());
		String sql = new String();		
		
		sql = "select p from Pedido p where p.codigo = "+codigo;		
		
		Query query = manager.createQuery(sql);
		
		listaPedido = query.getResultList();
		
		manager.close();
		factory.close();
		
	for(Pedido p: listaPedido){
			
			pedido = p; 
			 
		}
	 
	 
	 return pedido;
 }
 
 public void salvarPedido(Pedido pedido){
	 
	 EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.merge(pedido);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	 
	 
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
	
	public List<Pedido> pesquisarPedidoAtivo(Pedido pedido){
		System.out.println("Passou Inicio");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		
		setListaPedido(new ArrayList<Pedido>());
		
		StringBuffer sb = new StringBuffer(100);
		
		sb.append("select p from Pedido p where p.status = 1");
		String condicao= " and ";
		
	
		
		if(pedido.getCodigo()!=0){
			System.out.println("passou do segundo");
			sb.append(condicao + " p.codigo = ");
			sb.append(pedido.getCodigo());
			sb.append(" ");
			condicao = " and ";
			
		}
		
		
		Query query = manager.createQuery(sb.toString());
		
		listaPedido = query.getResultList();
		
		manager.close();
		factory.close();
		
	
		
		return listaPedido;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

}
