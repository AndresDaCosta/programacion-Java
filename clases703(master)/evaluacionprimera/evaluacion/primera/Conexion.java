package evaluacion.primera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
/*
 * @author jorge andres da costa
 * 
 * esta clase se debe de crear los metodos de establacer la conexion y liberar los recursos para ser llamados en la clase 
 * RegionDao
 * 
 * 
 * */
public class Conexion {


	
	static Connection conn = null;
	static ResultSet rset = null;
	static Statement stmt = null;
	static Savepoint punto = null;
	public static Connection establecerconn() {
		//metodo de establecer conexion.d
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "medaigual");
			
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			punto = conn.setSavepoint();
			conn.commit();
			
			
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void cerraconn(){
		//metodo de  liberar recursos
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
				
	}	
	
	
}

	
	

