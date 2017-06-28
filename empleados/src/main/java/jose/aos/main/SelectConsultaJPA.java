package jose.aos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import jose.aos.entitis.Departments;




public class SelectConsultaJPA {

public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactory();
		EntityManager em  =  emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			tx.begin();
			
			TypedQuery<Departments> query = em.createNamedQuery("Departments.pornombre", Departments.class);					
			query.setParameter("name", "Operations");
			Departments d = query.getSingleResult();
			System.out.println(d.getDepartmentId() + " " + d.getDepartmentName());
			query.setFlushMode(FlushModeType.AUTO); // cada vez que ejecto una instruccion tiene reflejo en BBDD. Por defecto.
			query.setFlushMode(FlushModeType.COMMIT); // cada vez que hago un commit, no antes, tiene reflejo en BBDD
			
			tx.commit();
			em.close();
			emf.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

		}

	}

}
