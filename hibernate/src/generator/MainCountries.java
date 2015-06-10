package generator;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MainCountries {
public static void main(String[] args) {
	

	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
	Transaction trasacion = null;
	Session sesion1 = null;
	try{
	
		sesion1 = factory.openSession();
		trasacion = sesion1.beginTransaction();
		
			List<Regions> list = sesion1.createSQLQuery("select * from Regions").addEntity(Regions.class).list();
			Iterator<Regions> it = list.iterator();
			
		Regions region1;
		Countries pais;
		
		while(it.hasNext()){
			region1 = it.next();
				System.out.println(region1.getRegionName());
				Iterator<Countries> it_pais = region1.getCountrieses().iterator();
			while(it_pais.hasNext()){
				pais = it_pais.next();
					System.out.println(pais.getCountryName());
			}
		}
		
		
		
		
	}
	catch(Exception e){
		e.printStackTrace();
			trasacion.rollback();
	}
	finally{
		sesion1.disconnect();
		factory.close();
	}
	
	
	
	}
}