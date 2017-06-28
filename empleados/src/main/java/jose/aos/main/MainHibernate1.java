package jose.aos.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jose.aos.entitis.Regions;

public class MainHibernate1 {

	public static void main(String[] args) {

		SessionFactory sf = null;
		Transaction tx = null;
		try{
			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();

			try //realizamos la "transaccion"
			{
				tx =  sesion.beginTransaction();
				Regions rg = sesion.get(Regions.class, new BigDecimal(1));
				System.out.println("La region leida es -->"+rg.getRegionName()); //syso
				System.out.println("El Id es -->"+rg.getRegionId()); //syso
				tx.commit();				
			}catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}finally 
			{
				sesion.close();
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
