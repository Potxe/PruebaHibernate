package jose.aos.main;

import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jose.aos.entitis.Regions;

public class MainHibernate2 {

	public static void main(String[] args) {

		SessionFactory sf = null;
		Transaction tx = null;
		try{
			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();

			try //realizamos la "transaccion"
			{				
				Regions rg = new Regions();
				rg.setRegionId(new BigDecimal(55));
				rg.setRegionName("Txikitistan2");
				
				tx =  sesion.beginTransaction();
				sesion.save(rg);
				
				rg.setRegionName("Azkoitia");

				tx.commit();	
				
				Regions rg2 = sesion.get(Regions.class, new BigDecimal(33));
				System.out.println("La region leida es -->"+rg2.getRegionName()); //syso
				System.out.println("El Id es -->"+rg2.getRegionId()); //syso
				
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
