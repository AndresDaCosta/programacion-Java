package Generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmpleadosDao {

	/****************************************************************************************************
	 * @author jorge andre da costa
	 * @date 12/06/2015
	 * 
	 * clase que contiene la query que devuelve la lista de empleados a la que queremos subir el sueldo
	 * 
	 * **************************************************************************************************/
	
	
		Session sesion = null;     //declaro un objeo sesion y lo igualo a null
	
	public   List<Employees> listaempleados(){      //dreclaro un metodo de obtencion de lista empleados 
		
		List<Employees> listempleados= null;        //declaro una lista de empleados y la igualo a null
		
		listempleados = this.sesion.createSQLQuery("select * from employees").addEntity(Employees.class).list();
				
		//ejecuto la Query a la BBDD para que "yo" lo meta en una lista
			
		
		return listempleados; 				//devuelvo la lista de empleados
	}
	
	
	public void setSesion(Session sesion2) {       //declaro un metodo para obtener la conexion que no me devuelve nada
		
		this.sesion = sesion2;						//igualo el objeto sesion a sesion 2
		
	}
	public Session getSesion() {  					//declaro un metodo de get sesion para que me devuelva el objeto de sesion
					
		return this.sesion;          //devuelvo esta sesion
	}
	
	
}