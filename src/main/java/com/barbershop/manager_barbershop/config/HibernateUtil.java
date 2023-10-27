package com.barbershop.manager_barbershop.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.barbershop.manager_barbershop.entity.CustomerEntity;
import com.barbershop.manager_barbershop.entity.AppointmentEntity;
import com.barbershop.manager_barbershop.entity.BillEntity;
import com.barbershop.manager_barbershop.entity.CouponEntity;
import com.barbershop.manager_barbershop.entity.CustomerEntity;
import com.barbershop.manager_barbershop.entity.ServiceEntity;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/baberShop?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "1234");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

//				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				settings.put(Environment.HBM2DDL_AUTO, "none");
				configuration.setProperties(settings);

				configuration.addAnnotatedClass(CustomerEntity.class);
				configuration.addAnnotatedClass(AppointmentEntity.class);
				configuration.addAnnotatedClass(BillEntity.class);
				configuration.addAnnotatedClass(CouponEntity.class);
				configuration.addAnnotatedClass(CustomerEntity.class);
				configuration.addAnnotatedClass(ServiceEntity.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
