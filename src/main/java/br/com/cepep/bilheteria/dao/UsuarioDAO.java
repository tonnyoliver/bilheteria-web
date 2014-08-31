package br.com.cepep.bilheteria.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.cepep.bilheteria.modelo.Usuario;
import br.com.cepep.bilheteria.util.HibernateUtil;

public class UsuarioDAO {

	private Session session;
	
	public UsuarioDAO() {
		this.session = HibernateUtil.getSession().openSession();
	}
	
	public Usuario adicionar(Usuario usr){
		Transaction transaction = session.beginTransaction();
		session.save(usr);//INSERT INTO usuario (colunas...) VALUES (vals...)
		transaction.commit();
		session.close();
		return usr;
	}
	
	public Usuario validarUsuario(String login, String senha){
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Usuario.class);//SELECT * FROM usuario
		criteria.add(Restrictions.eq("login", login));//WHERE login = ?
		criteria.add(Restrictions.eq("senha", senha));//AND senha = ?
		Usuario u = (Usuario) criteria.uniqueResult();//libera o comando pra ser executado
		transaction.commit();//Envia o comando, porque usamos um trasaction
		session.close();//Fecha a sessão para não consumir recursos
		return u;//retorna o objeto recuperado (se não existir, será null)
	}

}
