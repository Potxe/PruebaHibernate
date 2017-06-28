package jose.aos.main;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAFactory {
	
	private static EntityManagerFactory factory;
	
	static
	{
		new JPAFactory();
	}
	
	private JPAFactory()
	{

		
		try
		{	
			factory = Persistence.createEntityManagerFactory("unit");// configuration
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManagerFactory getEntityManagerFactory ()
	{
		return factory;
	}
	
}
