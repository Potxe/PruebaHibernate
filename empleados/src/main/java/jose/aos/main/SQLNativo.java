package jose.aos.main;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jose.aos.entitis.Employees;


public class SQLNativo {

	public static void main(String[] args) {
		
		Session sesion = HibernateFactory.getSessionFactory().openSession();
		Transaction tx =  sesion.beginTransaction();
		
		//SQLQuery qNativa = sesion.createSQLQuery("SELECT employee_id, email from employees");	
		SQLQuery qNativa = sesion.createSQLQuery("SELECT* from employees");
		qNativa.addEntity(Employees.class);
		List <Employees> lde =  qNativa.list();
		
		//NO RULA PORQUE ESTA DEFINIDO EL FILTRO EN HQL
		Filter filtro = sesion.enableFilter("employeefilter");
		filtro.setParameter("salary", 16000);
		//NO RULA PORQUE ESTA DEFINIDO EL FILTRO EN HQL
		
		
		for( Employees empleado : lde)
		{
			System.out.print(empleado.getFirstName());
			System.out.print("-->"+empleado.getEmployeeId());
			System.out.println("-->"+empleado.getSalary());
		}
		tx.commit();
		sesion.close();
		HibernateFactory.getSessionFactory().close();	

	}

}
