package jose.aos.main;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jose.aos.entitis.Employees;


public class HQLFilter {

	public static void main(String[] args) {
		
		Session sesion = HibernateFactory.getSessionFactory().openSession();
		Transaction tx =  sesion.beginTransaction();
		
		Filter filtro = sesion.enableFilter("employeefilter");
		filtro.setParameter("salary", 16000);
		
		
		Query query = sesion.createQuery("from Employees e"); //creado con sintaxis HQL		
		List <Employees> lde = query.list();
		
		for( Employees e: lde)
		{
			System.out.print(e.getFirstName());
			System.out.println("-->"+e.getSalary());
		}
		tx.commit();
		sesion.close();
		HibernateFactory.getSessionFactory().close();	

	}

}
