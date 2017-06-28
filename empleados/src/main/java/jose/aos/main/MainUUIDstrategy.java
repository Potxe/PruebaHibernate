package jose.aos.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jose.aos.entitis.Reguistro;

public class MainUUIDstrategy {

	public static void main(String[] args) {

		SessionFactory sf = HibernateFactory.getSessionFactory();
		try{
			Session sesion = sf.openSession();
			Transaction tx = sesion.beginTransaction();
			
			Reguistro r1 = new Reguistro();
			Reguistro r2 = new Reguistro();
			Reguistro r3 = new Reguistro();

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
