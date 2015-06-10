package generator;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/*******************************************************************************************************************
 *  @author: jorge andres da dosta ribeiro
 *  @date: 10/06/2015
 * 	
 * crear un programa para que te muestre a traves de las regiones todos los paise que pertenecen a esas regiones
 * 
 * version. 1.0
 * 
 * ****************************************************************************************************************/
public class MainCountries {
public static void main(String[] args) {
	

	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
	//creo y llamo a las configuraciones de hibernate y despues me creo un builder de factory y lo creo
	
	Transaction trasacion = null; 	//declaro la variable del factory
	Session sesion1 = null;			//declaro una variable de session
	try{
	
		sesion1 = factory.openSession();			//habro la sesion
		trasacion = sesion1.beginTransaction();		//y habro una trasaccion
		
			List<Regions> list = sesion1.createSQLQuery("select * from Regions").addEntity(Regions.class).list();
				
					//ejecuto la Query para que me salgan todas la razones
								
			Iterator<Regions> it = list.iterator();			//creo un interator para "interactuar con la lista
			
			
		Regions region1;  	//declaro una region	
		Countries pais;		//declaro un pais		
		
		while(it.hasNext()){
			
			//abro un bucle que funciona mientras el interador tenga siguiente
			
			region1 = it.next();  																 						//a la region le doy valor del interador
				
				System.out.println("\n" + "se van a mostrar los paises de la region " + region1.getRegionName());   	//imprimo en pantalla la region 
				Iterator<Countries> it_pais = region1.getCountrieses().iterator();   			 						//seteo un interador para el pais
				
			while(it_pais.hasNext()){
				
				//el bucle interactua con la lista de paises para que me las muestre
				
				pais = it_pais.next();                          														//pais toma valor del interator
					System.out.println("\n" + pais.getCountryName() + " pertenece a " + region1.getRegionName());		//imprimo en pantalla el pais
			}
		}
		
		
		
		
	}
	catch(Exception e){
		
		//si llega a "aqui" algo va muy mal!!!!!!!
		
		e.printStackTrace();	      	//salta la exception	
			trasacion.rollback();		//activo el rollback para volver atras
	}
	finally{
		
		//si llega a "aqui" todo a ido de perlas :)
		
		sesion1.disconnect();    		//cierro la sesion
		factory.close(); 				//y cierro el factory
	}
	
	
	
	}
}