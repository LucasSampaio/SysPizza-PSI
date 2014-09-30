package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.UsuarioDao;
import negocio.Cliente;
import negocio.Funcionario;
import negocio.Usuario;


@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class UsuarioBean  implements java.io.Serializable {
	
	private Usuario usuario;
	private Cliente cliente;
	private Funcionario funcionario;
	private Boolean rendermenu = false;
	private Boolean renderlogin;
	private List<Usuario> listaUsuario;
	private UsuarioDao usuarioDao;
	
	
	
	
	public UsuarioBean(){
		if(usuario==null){
			System.out.println("Entrou no construtor");
		setUsuario(new Usuario());
		rendermenu=false;
		renderlogin=true;
		
		}
		
	}
	
	public String prepararCadastro(){
		
		
		return "cadastro";
	}
	
	public void limparObjeto(){
		
		setUsuario(new Usuario());
		setListaUsuario(new ArrayList<Usuario>());
		
	}
	
	public void pesquisarUsuario(){
		setListaUsuario(new ArrayList<Usuario>());
		setUsuarioDao(new UsuarioDao());
		if(usuario.getLogin()!=""  ||usuario.getSenha()!=""){
			
			setListaUsuario(usuarioDao.pesquisar(usuario));	
		
		
		
			if (listaUsuario.size()!=0){
				
				rendermenu = true;
				renderlogin = false;
			}
			
			
		}
		
		
		
		
	}
	
	
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Boolean getRendermenu() {
		return rendermenu;
	}

	public void setRendermenu(Boolean rendermenu) {
		this.rendermenu = rendermenu;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Boolean getRenderlogin() {
		return renderlogin;
	}

	public void setRenderlogin(Boolean renderlogin) {
		this.renderlogin = renderlogin;
	}


}
