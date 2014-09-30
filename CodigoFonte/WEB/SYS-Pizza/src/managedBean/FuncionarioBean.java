package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.FuncionarioDao;
import negocio.Cliente;
import negocio.Funcionario;



@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class FuncionarioBean  implements java.io.Serializable{
	
	private Funcionario funcionario;
	private Cliente cliente;
	private FuncionarioDao funcionarioDao;
	private List<Funcionario> listaFuncionario;
	private Boolean render;
	
	
	
	
	public void limparObjeto(){
		
		setFuncionario(new Funcionario());
		setCliente(new Cliente());
		setFuncionarioDao(new FuncionarioDao());
		setListaFuncionario(new ArrayList<Funcionario>());
	}
	
	
	public String salvar(){
		
		funcionarioDao.salvar(funcionario);
		limparObjeto();
		
		return"voltar";
	}
	
	public String preparar(){
		
		limparObjeto();
		
		return "cadastrarFuncionario";
		
	}
	
	public String prepararPesquisa(){
		limparObjeto();
		render = false;
		return "pesquisarFuncionario";
	}
	
	public void pesquisar(){
		render = true;
		setListaFuncionario(funcionarioDao.pesquisar(funcionario));
		
	}
	


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public FuncionarioDao getFuncionarioDao() {
		return funcionarioDao;
	}


	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}


	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}


	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}


	public Boolean getRender() {
		return render;
	}


	public void setRender(Boolean render) {
		this.render = render;
	}

}
