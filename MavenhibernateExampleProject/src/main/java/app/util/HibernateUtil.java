package app.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import app.model.Account;

//singleton
 //create a static reference
 //create a static method that returns the object
 //In the method check if the ref is null if so then generate the object else
 //return the existing object

public class HibernateUtil {
	private static SessionFactory sessionFactory;//singleton-Design pattern
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			Configuration configuration = new Configuration();
			Properties properties = new Properties();
			properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL55Dialect" );
			properties.put(Environment.DRIVER,"com.mysql.jdbc.Driver" );
			properties.put(Environment.USER,"root");
			properties.put(Environment.PASS,"Ronaldosrini32");
			properties.put(Environment.SHOW_SQL,"true");
			properties.put(Environment.HBM2DDL_AUTO,"create-drop");
			configuration.setProperties(properties);
			configuration.addAnnotatedClass(Account.class);
			ServiceRegistry sr = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(sr);
			
		}
		return sessionFactory;
		
	}

}
