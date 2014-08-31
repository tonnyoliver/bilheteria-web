package br.com.cepep.bilheteria.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory session = buildSession();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSession() {
		Configuration cfg = new Configuration();
		cfg.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				cfg.getProperties()).build();
		SessionFactory session = cfg.buildSessionFactory(serviceRegistry);
		return session;
	}

	public static SessionFactory getSession() {
		return session;
	}

}
