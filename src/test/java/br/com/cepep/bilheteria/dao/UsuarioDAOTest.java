package br.com.cepep.bilheteria.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.cepep.bilheteria.modelo.Usuario;

public class UsuarioDAOTest {

	@Test
	public void test() {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.validarUsuario("admin", "admin");
		assertEquals("admin", usuario.getLogin());
		
	}

}
