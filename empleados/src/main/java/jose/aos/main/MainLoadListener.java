package jose.aos.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;

import jose.aos.entitis.Regions;

public class MainLoadListener {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactory();
		EntityManager em  =  emf.createEntityManager();
		
		
		//ACTIVACION DE LISTENER EVENTOS EN VERSION 5 HIBERNATE
		
		SessionFactoryImpl sfi = emf.unwrap(SessionFactoryImpl.class);
		EventListenerRegistry registro = sfi.getServiceRegistry().getService(EventListenerRegistry.class); //objeto que me permite activar el registro de los load, poder asociasr el listner.
		registro.getEventListenerGroup(EventType.LOAD).appendListener(new MyLoadListener());
		
		Session sesion = sfi.openSession(); //sesion de hibernate
		Transaction tx = sesion.beginTransaction();//transaccion de hibernate
		
		sesion.get(Regions.class, new BigDecimal(1));
		
		tx.commit();
		sesion.close();
		emf.close();

	}

}
