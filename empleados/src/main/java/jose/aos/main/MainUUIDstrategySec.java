package jose.aos.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jose.aos.entitis.RegistroSec;


public class MainUUIDstrategySec {

	public static void main(String[] args) {

		SessionFactory sf = HibernateFactory.getSessionFactory();
		try{
			Session sesion = sf.openSession();
			Transaction tx = sesion.beginTransaction();
			
			RegistroSec r1 = new RegistroSec();
			RegistroSec r2 = new RegistroSec();
			RegistroSec r3 = new RegistroSec();

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
