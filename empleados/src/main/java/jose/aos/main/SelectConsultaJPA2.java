package jose.aos.main;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import jose.aos.entitis.Departments;
import jose.aos.entitis.Regions;




public class SelectConsultaJPA2 {

public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactory();
		EntityManager em  =  emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			tx.begin();
			
			TypedQuery<Departments> query = em.createNamedQuery("Departments.todos", Departments.class);					

			List <Departments> ldd = query.getResultList();
			
			for( Departments d: ldd)
			{
				System.out.print(d.getDepartmentName());
				System.out.println("-->"+d.getDepartmentId());
			}
			
			tx.commit();
			em.close();
			emf.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

		}

	}

}
