package evaluacion.primera;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/*
 * author: jorge andres da costa ribeiro
 * 
 *metodo que contiene las llamadas a los metodos de las clases de conexion, intrucciones, regionDTO para 
 *asi recolectar toda la imformacion y guardar la info en un arraylist para que despues el main del programa
 *la muestre en pantalla. 
 *
 * */
public class RegionDao {

	Conexion conexion1 = new Conexion();
	//declaro un nuebo object de conexion para invocar a la conexion que se hace ahora
	
	
	
	Statement stm = null;
	ResultSet rs = null;
	RegionDTo region = null;
	
	public static List<RegionDTo> obtenertodos(){
		Conexion conexion2 = null;
		Statement stm = null;
		ResultSet rs = null;
		RegionDTo region = null;
		
		conexion2 = Connection.establecerconn();
		
		
		
	}
	
}
