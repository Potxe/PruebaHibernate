package jose.aos.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jose.aos.entitis.Regions;

public class SelectCriteria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactory();
		EntityManager em  =  emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			tx.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<String> cq = cb.createQuery(String.class);
			Root<Regions> root = cq.from(Regions.class);
			
			cq.select(root.get("regionName").as(String.class));
			
			TypedQuery<String> tq = em.createQuery(cq);
			List<String> lnr = tq.getResultList();
			
			for( String str: lnr)
			{
				System.out.println(str);
			}
			tx.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}

	}

}
