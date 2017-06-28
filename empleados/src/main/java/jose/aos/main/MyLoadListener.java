package jose.aos.main;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class MyLoadListener implements LoadEventListener{

	public void onLoad(LoadEvent evento, LoadType type) throws HibernateException {
		System.out.println("LOAD--> "+evento);
		
	}

}
