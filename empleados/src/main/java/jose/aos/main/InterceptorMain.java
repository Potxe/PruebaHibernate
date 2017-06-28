package jose.aos.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jose.aos.entitis.RegistroTabla;


public class InterceptorMain {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateFactory.getSessionFactory();
		
		Session sesion = sf.withOptions().interceptor(new MyInterceptor()).openSession();
		Transaction tx =  sesion.beginTransaction();
		
		RegistroTabla registro = new RegistroTabla();
		sesion.save(registro);
		tx.commit();
		sesion.close();
		sf.close();	
	}

}
