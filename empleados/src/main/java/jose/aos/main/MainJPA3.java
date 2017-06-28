package jose.aos.main;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jose.aos.entitis.Employees;

public class MainJPA3 {

	public static void main(String[] args) {
		//paso de JPA e HIBERNATE

		EntityManagerFactory emf = null;
		EntityManager em  = null;
		
		try{
			emf = JPAFactory.getEntityManagerFactory();
			em = emf.createEntityManager();
			
			//transformo a hibernatesesionfactory
			//paso al api de hibernate	desde JPA		
			SessionFactory sf = emf.unwrap(SessionFactory.class);
			Session sesion = sf.openSession();			
			Transaction txh = sesion.beginTransaction();
			
			try //realizamos la "transaccion"
			{
				Employees e = sesion.get(Employees.class, 100);
				System.out.println(e.toString());

				txh.commit();				
			}catch (Exception e) {
				e.printStackTrace();
				txh.rollback();
			}finally 
			{
				em.close();
			}
		}
		catch (Throwable t) {
			t.printStackTrace();
		}finally //libero conexion siempre 
		{
			emf.close();
		}

	}

}
