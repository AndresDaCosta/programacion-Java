package generator;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;






import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToStringTransformer;
/*
 * @author: jorge andre da costa ribeiro
 * @date: 10/6/2015
 * 
 * crear un metodo que interactue con la BBDD, que aumente el salario de los empleados del departamento de ventas un 20%
 * 
 * version: 1.0
 * */


public class MainPersistencia {
	private static int nuevosalario = 0;
	private static final double porcentaje = 1.20;
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		/*primero me creo una nueva configuracion para llamar al fichero de config de hibernate
		 * despues me creo un builder para que reciba el registro para hacer un factory
		 * y al final me creo un factory para la sesion 
		 * */
		
		Session sesion1 = null;           //declaro una variable de sesion
		Transaction trasacion = null;    //y me declaro una variable de transaccion 
		
		try{
			sesion1 = factory.openSession();           //abro la sesion con el factory
			trasacion = sesion1.beginTransaction();   //y abro con la sesion antes creada una transaccion
			@SuppressWarnings("unchecked")
			List<Employees> list = sesion1.createSQLQuery("select * from employees where department_id = 80").addEntity(Employees.class).list();
			
				//delclaro una lista de empleados para meter ahi toda la imformacion de la query planteada a la BBDD.

			Iterator<Employees> it = list.iterator();
			
				//me declaro un interador para interactuar con la lista y sacar info
			
			Employees empleado;
			BigDecimal big = null;
			
				//declaro las variable de empleado para saber en que empleado voy
				//y una variable de BIGDECIMAL para el sueldo final y pasarlo a la BBDD
			
			while(it.hasNext()){
				
				//con el bucle quiero hacer que mientra que el interador tenga siguiente haga lo siguiente
				
				empleado = it.next();
				
				//empleado toma valor del interador
				
				nuevosalario = (int)(empleado.getSalary().doubleValue() * porcentaje );
				
				//calculo el salario como int cogiendo el salario de empleado y lo cambio a  double
				//y despues lo multiplico por el porcentaje delcarado al principio
				
				System.out.println("el empleado " + empleado + " tendra un salario final " + nuevosalario);
				
				//imprimo en pantalla la frase para saber que ha llegado a "buen puerto" el calculo
				
				big = new BigDecimal(nuevosalario);
				
				//cambio la variable big que toma valo nuevo salario
				
				empleado.setSalary(big);			//seteo que el salario que toma el valor de big
				
				sesion1.update(empleado);			//actualizo la sesion para que se guarde
				System.out.println("se ha seteado correctamente");	//printeo en pantalla para saber "que se completo"
				
			}
			trasacion.commit();		//hago un comit para guardalo "ya" en la BBDD
		}
		catch(Exception e){			//si falla algo de lo anterior viene "Aqui"
			e.printStackTrace();
			trasacion.rollback();	//se ejecuta un rollback para a deshacer
			
		}
		finally{
				//si todo va bien llega a "aqui"
			sesion1.disconnect();		//me desconecto de la sesion
			factory.close();			//y cierro el factory
		}
		
	}
}
