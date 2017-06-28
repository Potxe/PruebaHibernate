package jose.aos.main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import jose.aos.entitis.Countries;
import jose.aos.entitis.Regions;

public class MainJPA1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityTransaction tx = null;
		EntityManager em  = null;
		try{
			emf = JPAFactory.getEntityManagerFactory();
			 em = emf.createEntityManager();
			

			try //realizamos la "transaccion"
			{
				tx =  em.getTransaction();
				tx.begin(); //en JPA hay que ahcer el beguin de la transaccion
				Regions rg = em.find(Regions.class, new BigDecimal(1));
				System.out.println("La region leida es -->"+rg.getRegionName()); //syso
				System.out.println("El Id es -->"+rg.getRegionId()); //syso
				
				
				System.out.println("MOSTRAR PAISES"); //syso
				Set<Countries> cjto_paises = rg.getCountrieses();
				
				Iterator <Countries> it = cjto_paises.iterator();
				Countries caux = null;
				while (it.hasNext()){
					caux = it.next();
					System.out.println(caux.toString());
				}
				
				tx.commit();				
			}catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
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
