package jose.aos.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jose.aos.entitis.RegistroTabla;


public class MainUUIDstrategyTabla {

	public static void main(String[] args) {

		SessionFactory sf = HibernateFactory.getSessionFactory();
		try{
			Session sesion = sf.openSession();
			Transaction tx = sesion.beginTransaction();
			
			RegistroTabla r1 = new RegistroTabla();
			RegistroTabla r2 = new RegistroTabla();
			RegistroTabla r3 = new RegistroTabla();

			sesion.save(r1);
			sesion.save(r2);
			sesion.save(r3);
			
			tx.commit();
			sesion.close();
			sf.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
