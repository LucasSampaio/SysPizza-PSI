package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ClienteDao;
import negocio.Cliente;
import negocio.Funcionario;
import negocio.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class ClienteBean implements java.io.Serializable {
	
	private Cliente cliente;
	private Funcionario funcionario;
	private ClienteDao clienteDao;
	private Usuario usuario;
	private List<Cliente> listaCliente;
	private Boolean render;
	
	
	
	
	
	public String preparar(){
		limparObjeto();
		return"cadastrarCliente";
	}
	
	public String prepararPesquisa(){
		
		limparObjeto();
		render= false;
		return "prepararPesquisa";
	}
	
	public void carregarObjeto(){
		
		limparObjeto();
	}
	
	public void limparObjeto(){
		setUsuario(new Usuario());
		setCliente(new Cliente());
		setFuncionario(new Funcionario());
		setClienteDao(new ClienteDao());
		setListaCliente(new ArrayList<Cliente>());
		//ok
	}
	
	public void salvar(){
		
		clienteDao.salvar(cliente, usuario);
		
		limparObjeto();
	}
	
	public void pesquisar(){
		
	 render= true;
	// clienteDao.pesquisar(cliente);
	 setListaCliente(getClienteDao().pesquisar(cliente));
	 
	System.out.println("Pesquisa realizada");
	}
		
	
	
	
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Boolean getRender() {
		return render;
	}

	public void setRender(Boolean render) {
		this.render = render;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
