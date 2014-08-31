package br.com.cepep.bilheteria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cepep.bilheteria.dao.UsuarioDAO;
import br.com.cepep.bilheteria.modelo.Usuario;
import br.com.cepep.bilheteria.util.Page;
import br.com.cepep.bilheteria.util.SessionUtil;
import br.com.cepep.bilheteria.util.SesssionUtil;

@ManagedBean
@ViewScoped
public class LoginBean {
// Mudando so esta linha
	private String usuario;
	private String senha;
	
	public String autenticar(){
		
		Usuario usr = SessionUtil.autenticarUsuario(usuario, senha);
		
		if(usr!=null){
			if(SessionUtil.iniciaSessao(usr)){
				return getPaginaInicial(usr);
			}else{
				return Page.LOGIN.getDescription();
			}
		}else{
			FacesMessage msg = new
					
			FacesMessage(FacesMessage.SEVERITY_ERROR, "Login"
					, "Usuário ou senha inválidos");
			
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return Page.LOGIN.getDescription();
		}
	}
	
	public String getPaginaInicial(Usuario usr){
		switch(usr.getPerfil()){
			case ADMIN:
				return Page.ADMIN.toString();
			case VENDEDOR:
				return Page.BILHETERIA.toString();
			default:
				return Page.LOGIN.toString();
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
