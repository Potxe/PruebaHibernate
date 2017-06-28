package jose.aos.main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jose.aos.entitis.Countries;
import jose.aos.entitis.Employees;
import jose.aos.entitis.Regions;

public class MainHibernateEjercicio {

	public static void main(String[] args) {

		SessionFactory sf = null;
		Transaction tx = null;
		try{
			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();

			try //realizamos la "transaccion"
			{
				tx =  sesion.beginTransaction();
				int i= 100;
				Employees eaux = new Employees();
				for (i = 100; i < 202; i++){
					eaux = sesion.get(Employees.class, i);
					System.out.println("El idEmpleado es-->"+eaux.getEmployeeId());
					System.out.println("El salario inicial es-->"+eaux.getSalary());
					double salario_inicial = eaux.getSalary().doubleValue();
					salario_inicial = salario_inicial*1.07;
					BigDecimal salariofinal = new BigDecimal(salario_inicial);
					eaux.setSalary(salariofinal);
					System.out.println("El salario final es-->"+eaux.getSalary());
					//sesion.save(eaux); //no es necesario porque lo tengo en estado persistence.
					//sesion.update(eaux);
				}
				System.out.println("voy a darle al commit");
				tx.commit();				
			}catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}finally 
			{
				sf.close();
			}
		}
		catch (Throwable t) {
			t.printStackTrace();
		}finally //libero conexion siempre 
		{
			sf.close();
		}

	}

}
