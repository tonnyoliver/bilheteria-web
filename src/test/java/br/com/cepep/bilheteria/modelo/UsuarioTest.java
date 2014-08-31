package br.com.cepep.bilheteria.modelo;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.cepep.bilheteria.dao.UsuarioDAO;
import br.com.cepep.bilheteria.util.HibernateUtil;

public class UsuarioTest {
	
	private Session session;

	@Before
	public void iniciaSessao() {
		session = HibernateUtil.getSession().openSession();
	}
	
	@After
	public void fechaSessao() {
		session.close();
	}
	
	@Test
	public void criaUsuario(){
		Usuario u = new Usuario();
		u.setEmail("test@mail.com");
		u.setLogin("admin");
		u.setSenha("admin");
		u.setPerfil(PerfilUsuario.VENDEDOR);
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.adicionar(u);
		assertTrue(true);
		
	}

	@Test
	public void criarOBancoDeDadosSemErros(){
		Transaction transaction = session.beginTransaction();
		Usuario usr = new Usuario();
		usr.setLogin("admin");
		usr.setEmail("admin@admin.com");
		usr.setPerfil(PerfilUsuario.ADMIN);
		usr.setSenha("admin");
		usr.setUltimoLogin(Calendar.getInstance());
		session.save(usr);
		transaction.commit();
		assertTrue(true);
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void oLoginDeveSerUnico(){
		Transaction transaction = session.beginTransaction();
		Usuario usr = new Usuario();
		usr.setLogin("admin");
		session.save(usr);
		transaction.commit();
	}

}
