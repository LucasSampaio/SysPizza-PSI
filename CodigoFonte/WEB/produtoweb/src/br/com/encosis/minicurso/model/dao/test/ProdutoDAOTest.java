package br.com.encosis.minicurso.model.dao.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.Test;
import br.com.encosis.minicurso.model.bean.Produto;
import br.com.encosis.minicurso.model.dao.JPAUtil;
import br.com.encosis.minicurso.model.dao.ProdutoDAO;

public class ProdutoDAOTest {

	@Test
	public void testCadastrar() {
		// Solicitacao de conexao ao SGBD
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(entityManager);
		// Inicio da transacao
		entityManager.getTransaction().begin();
		// Criacao de um novo produto
		Produto produto = new Produto();
		produto.setNome("bola");
		produto.setDescricao("futebol de campo");
		produto.setDataCadastro(Calendar.getInstance());
		produto.setEstoque(10.5f);
		produto.setPreco(45.5);
		//Execucao do cadastro
		dao.cadastrar(produto);
		//Fechamento da conexao
		entityManager.getTransaction().commit();
		entityManager.close();
		
		//Realiza��o do teste de cadastro
		Assert.assertNotNull(produto.getId());
	}

	// Continuacao...
	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultar() {
		fail("Not yet implemented");
	}

	@Test
	public void testListar() {
		fail("Not yet implemented");
	}

}
