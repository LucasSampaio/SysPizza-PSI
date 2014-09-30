package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocio.Cliente;
import negocio.Funcionario;

public class FuncionarioDao {
	
	private Funcionario funcionario;
	private List<Funcionario> lista;
	
	
	public String salvar(Funcionario funcionario){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(funcionario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		System.out.println("Registro efetuado com sucesso");
		
		
		return "voltar";
	}
	
public String alteracao(Funcionario funcionario){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(funcionario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		System.out.println("Registro efetuado com sucesso");
		
		
		return "voltar";
	}




public List<Funcionario> pesquisar(Funcionario funcionario){
	System.out.println("Passou Inicio");
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("novo");
	EntityManager manager = factory.createEntityManager();
	
	setLista(new ArrayList<Funcionario>());
	
	StringBuffer sb = new StringBuffer(100);
	
	sb.append("select f from Cliente f ");
	String condicao= " where ";
	
	if(funcionario.getNome()!=""){
		System.out.println("passou do primeiro");
		sb.append(condicao +"f.nome = '");
		sb.append(funcionario.getNome()+"'");
		sb.append(" ");
		condicao = " and ";
	}
	
	if(funcionario.getCpf()!=""){
		System.out.println("passou do segundo");
		sb.append(condicao + " f.cpf = ");
		sb.append(funcionario.getCpf());
		sb.append(" ");
		condicao = " and ";
		
	}
	
	
	Query query = manager.createQuery(sb.toString());
	
	lista = query.getResultList();
	
	manager.close();
	factory.close();
	

	
	return lista;
}
	
	
	
	
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getLista() {
		return lista;
	}

	public void setLista(List<Funcionario> lista) {
		this.lista = lista;
	}

}
