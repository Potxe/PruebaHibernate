package jose.aos.main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import jose.aos.entitis.Employees;



public class SelectCriteria4 {

public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactory();
		EntityManager em  =  emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			tx.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			//selecciono EMPLOYEE_ID, FIRSTNAME
			CriteriaQuery<MiniEmpleado> cq = cb.createQuery(MiniEmpleado.class);
			Root<Employees> root = cq.from(Employees.class);
			
			Path<Integer> pathId = root.get("employeeId");
			Path<String> pathFn = 	root.get("firstName");
			
			//cq.select(cb.array(pathId,pathFn));
			cq.select(cb.construct(MiniEmpleado.class, pathId, pathFn));

			
			TypedQuery<MiniEmpleado> tq = em.createQuery(cq);					
			List<MiniEmpleado> lme = tq.getResultList();
			
			
			for( MiniEmpleado me: lme)
			{
				System.out.print(me.getEmployedId()); //ID
				System.out.println("-->"+me.getFirstName()); //FIRSTNAME
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
