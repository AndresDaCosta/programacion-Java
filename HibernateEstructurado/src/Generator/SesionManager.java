package Generator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SesionManager {
		/********************************************************************
		 * @author jorge andres da costa
		 * @date 12/06/2015
		 * 
		 *  crea una clase que maneje la sesion y las configuraciones
		 * 
		 * ******************************************************************/	 
	
	 static  {				//creo un metodo estatico "porque siempre va estar asi y no es necesario cambiarlo
		
		Configuration configuracion = new Configuration().configure();				//cojo la config de Hibernate
		StandardServiceRegistryBuilder constructor =  new StandardServiceRegistryBuilder().	
				applySettings(configuracion.getProperties());			//creo un nuevo builder y le aplico los cambios
		factory = configuracion.buildSessionFactory(constructor.build());     //le paso al factory la config del builder
		
		
	}
	 private static SessionFactory factory;
	 
	 private SesionManager (){}
	
	public static SessionFactory getSessionFactory(){         //creo un metodo de get factory que me devuelva el factory
		
		return factory; 						//devuelvo el factory
		
	}
	public static Session obtenerSesionNueva(){  						//creo un metodo para obtener una nueva sesion
		
		return factory.openSession();					//devuelvo una sesion abierta con ese factory
	}
	public static void cerrarSession(Session sesion){				//creo un metodo para cerrar la sesion
		
		sesion.close();										//devuelvo un cierre de sesion
	}
	public static void cerrarfactory(){
		factory.close();
	}
}
