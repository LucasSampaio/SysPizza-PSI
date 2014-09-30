package negocio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import javax.servlet.http.HttpSession;

import org.hibernate.Session;

@SessionScoped
@ManagedBean
public class SessionBean {
	
	public FacesContext fc;
	public HttpSession ses;
	public Item item;
	
//	FacesContext fc = FacesContext.getCurrentInstance();
	//HttpSession ses = (HttpSession) fc.getExternalContext().getSession(false);
		
	public SessionBean() {
		fc = FacesContext.getCurrentInstance();
		ses = (HttpSession) fc.getExternalContext().getSession(false);
		ses.setAttribute("codigo", item);
		
		// setar
		
		ses.getAttribute("codigo");
	}
	
	
	public FacesContext getFc() {
		return fc;
	}
	public void setFc(FacesContext fc) {
		this.fc = fc;
	}
	public HttpSession getSes() {
		return ses;
	}
	public void setSes(HttpSession ses) {
		this.ses = ses;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}
}
