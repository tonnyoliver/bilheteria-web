package br.com.cepep.bilheteria.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.cepep.bilheteria.dao.UsuarioDAO;
import br.com.cepep.bilheteria.modelo.Usuario;

public class SessionUtil {
	
	public static String USUARIO_LOGADO = "usuario_logado";

	public static Usuario autenticarUsuario(String login, String senha) {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.validarUsuario(login, converteParaMD5(senha));
		return usuario;
	}

	public static String converteParaMD5(String valor) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(valor.getBytes(), 0, valor.length());
			BigInteger i = new BigInteger(1, m.digest());
			return String.format("%1$032x", i);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}
	
	public static boolean iniciaSessao(Usuario usr) {
		HttpSession session = getSession();
		if (session == null || usr == null) {
			return false;
		}
		session.setAttribute(USUARIO_LOGADO, usr);
		return true;
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static Usuario getUsuario() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return (Usuario) session.getAttribute(USUARIO_LOGADO);
	}

}
