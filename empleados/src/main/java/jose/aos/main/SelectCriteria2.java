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

public class SelectCriteria2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactory();
		EntityManager em  =  emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			tx.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<Regions> cq = cb.createQuery(Regions.class);
			Root<Regions> root = cq.from(Regions.class);
			
			//cq.select(root); //sin filtros del where
			cq.select(root);
			cq.where(cb.equal(root.get("regionName"), "Europe"));
			
			TypedQuery<Regions> tq = em.createQuery(cq);
			List<Regions> lnr = tq.getResultList();
			//Regions rg = tq.getSingleResult(); //cuando sabemos que solo devuelve UNO
			
			for( Regions reg: lnr)
			{
				System.out.print(reg.getRegionName());
				System.out.println("-->"+reg.getRegionId());
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
