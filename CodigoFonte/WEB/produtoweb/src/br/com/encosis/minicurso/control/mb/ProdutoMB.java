package br.com.encosis.minicurso.control.mb;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.encosis.minicurso.model.bean.Produto;
import br.com.encosis.minicurso.model.dao.JPAUtil;
import br.com.encosis.minicurso.model.dao.ProdutoDAO;

@ViewScoped
@ManagedBean
public class ProdutoMB {
	//Atributos devem ser iniciados
	private Produto produto = new Produto();
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	//Atributo que guarda a colecao produtos armazenados em BD
	public List<Produto> listaProdutos = new ArrayList<Produto>();
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}	

	//Metodo invocado apos a classe ser carregada pelo servidor
	@PostConstruct
	public void carregarProdutos(){
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		listaProdutos = dao.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		em.getTransaction().begin();
		dao.excluir(produto);
		em.getTransaction().commit();
		em.close();
		carregarProdutos();
	}

	public void salvar(){
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		em.getTransaction().begin();
		produto.setDataCadastro(Calendar.getInstance());
		if(produto.getId()!=null){
			dao.alterar(produto);
		}else{
			dao.cadastrar(produto);
		}
		em.getTransaction().commit();
		em.close();
		produto  = new Produto();
		carregarProdutos();
	}
}
