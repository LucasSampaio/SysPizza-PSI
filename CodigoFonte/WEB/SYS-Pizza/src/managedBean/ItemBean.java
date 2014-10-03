package managedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ItemDao;
import dao.PagamentoDao;
import negocio.Compra;
import negocio.FormaPgt;
import negocio.Item;
import negocio.Pedido;


@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class ItemBean implements java.io.Serializable {
	
	private Item item;
	private List<Item> listaItem;
	private List<Compra> listaCompra;
	private ItemDao itemDao;
	private Compra compra;
	private Pedido pedido;
	private FormaPgt formaPgt;
	private PagamentoDao pagamentoDao;
	private Boolean render;
	private Boolean sessao = true;
	private List<SelectItem> listaPagamento;
	
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
		setFormaPgt(new FormaPgt());
		setItem(new Item());
		setListaPagamento(new ArrayList<SelectItem>());
		setListaItem(new ArrayList<Item>());
		setListaCompra(new ArrayList<Compra>());
		setPedido(new Pedido());
		setCompra(new Compra());
		setPagamentoDao(new PagamentoDao());
		setItemDao(new ItemDao());
		
	}
	
	public void carregarPagamento(){
		
		List<FormaPgt> listaTmpPagamento = pagamentoDao.pesquisar();
		
		for (FormaPgt f: listaTmpPagamento){
			
			
			getListaPagamento().add(new SelectItem(f.getCodigo(), f.getDescricao()));
			System.out.println("Descricao :"+ f.getDescricao());
		}
	}
	
	public String prepararPesquisa(){
		
		limparObjeto();
		render= false;
		
		return "prepararPesquisaItem";
	}
	
	public String prepararPedido(){
		
		limparObjeto();
		carregarPagamento();
		
		
		
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
			
			System.out.println("O objeto não esta nulo !!!");
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
	
	public void carregarCompra(){
		
		requestParam = (Map) FacesContext.getCurrentInstance().getApplication().createValueBinding("#{param}").getValue(FacesContext.getCurrentInstance());
		String codigo = (String)requestParam.get("codigo");
		item = new ItemDao().pesquisarSaborPorCodigo(new Integer(codigo));
		
		compra.setDescricao(item.getDescricao());
		compra.setValor(item.getPreco());
		compra.setItem(item);
		
		listaCompra.add(compra);
		
	}
	
	public void salvarPedido(){
		pedido.setStatus((long) 1);
		pedido.setFormaPgt(formaPgt);
		itemDao.salvarPedidoCompra(listaCompra, pedido, compra);
		
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


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public FormaPgt getFormaPgt() {
		return formaPgt;
	}


	public void setFormaPgt(FormaPgt formaPgt) {
		this.formaPgt = formaPgt;
	}


	public List<SelectItem> getListaPagamento() {
		return listaPagamento;
	}


	public void setListaPagamento(List<SelectItem> listaPagamento) {
		this.listaPagamento = listaPagamento;
	}


	public PagamentoDao getPagamentoDao() {
		return pagamentoDao;
	}


	public void setPagamentoDao(PagamentoDao pagamentoDao) {
		this.pagamentoDao = pagamentoDao;
	}

}
