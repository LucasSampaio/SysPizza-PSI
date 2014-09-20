package br.com.encosis.minicurso.model.bean;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Produto {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String descricao;
	//Armazenar apanas a data, sem hora
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;
	private double preco;
	private float estoque;
	
	//Metodos de GET e SET...
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public float getEstoque() {
		return estoque;
	}
	public void setEstoque(float estoque) {
		this.estoque = estoque;
	}
}
