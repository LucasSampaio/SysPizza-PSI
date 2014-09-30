package managedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ItemDao;
import negocio.Compra;
import negocio.Item;


@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class ItemBean implements java.io.Serializable {
	
	private Item item;
	private List<Item> listaItem;
	private List<Compra> listaCompra;
	private ItemDao itemDao;
	private Compra compra;
	private Boolean render;
	private Boolean sessao = true;
	
	private Long tipo;
	
	Map requestParam;
	HttpSession sessionScope;
	HttpServletRequest requestScope;
	
//	public FacesContext fc;
	//public HttpSession ses;
	
	public ItemBean(){
		
		if(sessao==false){
			
			item = (Item)sessionScope.getAttribute("editarItem");
			
			
			System.out.println("passou o ultimo objeto: "+ item.getDescricao());
		}
		
		
	}
	
	
	public void limparObjeto(){
		
		setItem(new Item());
		setListaItem(new ArrayList<Item>());
		setListaCompra(new ArrayList<Compra>());
		setCompra(new Compra());
		setItemDao(new ItemDao());
		
	}
	
	public String prepararPesquisa(){
		
		limparObjeto();
		render= false;
		
		return "prepararPesquisaItem";
	}
	
	public String prepararPedido(){
		
		limparObjeto();
		
		
		return "prepararPedido";
	}
	
	public void cadastrarItem(){
		System.out.println(" O tipo de Item e: "+ getTipo());
		itemDao.salvar(item);
		limparObjeto();
		
	}
	
	public void pesquisarItem(){
		setListaItem(new ArrayList<Item>());
		
		if(tipo ==1){
			render =true;
		setListaItem(getItemDao().pesquisarSabor(item));
		} 
		else if(tipo ==2){
			render =true;
			setListaItem(getItemDao().pesquisarBebida(item));
			}
		else if(tipo ==3){
			render =true;
			setListaItem(getItemDao().pesquisarSanduiche(item));
		}
		else if (tipo ==4){
			render =true;
			setListaItem(getItemDao().pesquisarDoce(item));
		}
		
		
	}
	
	public void carregarItem(Item item){
		
		this.item = item;
		
				
	}
	
	public void testarObjeto(){
		
		if(item!=null){
			
			System.out.println("O objeto n�o esta nulo !!!");
			System.out.println("codigo :" +item.getCodigo());
			System.out.println("Descricao :"+item.getDescricao());
			System.out.println("Quantidade :"+ item.getQuantidade());
		}
		
	}
	
	public void carregarAlteracao(){
		
		requestScope = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		sessionScope = requestScope.getSession();
		requestParam = (Map) FacesContext.getCurrentInstance().getApplication().createValueBinding("#{param}").getValue(FacesContext.getCurrentInstance());
		
		System.out.println("No inicio");
		
		String codigo = (String)requestParam.get("codigo");
		System.out.println("Depois do request da string");
		 item = new ItemDao().pesquisarSaborPorCodigo(new Integer(codigo));
		System.out.println("Depois do pesquisar sabor");
		sessionScope.setAttribute("editarItem", item);
		System.out.println("Depois de setar no atributo");
		
		
	//	 item=(Item) sessionScope.getSessionContext().getSession("editarItem");
		item = (Item)sessionScope.getAttribute("editarItem");
		
	}
	
	public String prepararCadastro(){
		limparObjeto();
		return "cadastrarSabor";
	}
	
	public String prepararCadastroBebida(){
		limparObjeto();
		return "cadastrarBebida";
	}
	
	public String prepararCadastroSanduiche(){
		limparObjeto();
		return "cadastrarSanduiche";
	}
	
	public String prepararCadastroDoces(){
		limparObjeto();
		return "cadastrarDoce";
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public Boolean getRender() {
		return render;
	}

	public void setRender(Boolean render) {
		this.render = render;
	}

	public Long getTipo() {
		return tipo;
	}

	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}


	public Map getRequestParam() {
		return requestParam;
	}


	public void setRequestParam(Map requestParam) {
		this.requestParam = requestParam;
	}


	public HttpSession getSessionScope() {
		return sessionScope;
	}


	public void setSessionScope(HttpSession sessionScope) {
		this.sessionScope = sessionScope;
	}


	public Boolean getSessao() {
		return sessao;
	}


	public void setSessao(Boolean sessao) {
		this.sessao = sessao;
	}


	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	public List<Compra> getListaCompra() {
		return listaCompra;
	}


	public void setListaCompra(List<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}

}