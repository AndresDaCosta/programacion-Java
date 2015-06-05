
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {
	
	
	public static void main(String[] args) throws Exception {
		
		ArrayList<Empleado> arrayempleado = new ArrayList();
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		int id;
		String fnombre;
		String snombre;
		String email;
		String pnum;
		Date fecha;
		String jobid;
		int salary;
		float comi;
		int manid;
		int depid;
		
		
		try
		{
			//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "medaigual");
  	        stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from employees where  salary > 3000");
			while (rset.next()){
				
			
			 id = rset.getInt("employee_id");
			 fnombre = rset.getString("first_name");
			 snombre = rset.getString("last_name");
			 email = rset.getString("email");
			 pnum = rset.getString("phone_number");
			 fecha = rset.getDate("hire_date");
			 jobid = rset.getString("job_id");
			 salary = rset.getInt("salary");
			 comi = rset.getFloat("commission_pct");
			 manid = rset.getInt("manager_id");
			 depid = rset.getInt("department_id");    
			
			 Empleado empleado = new Empleado(id, fnombre, snombre, email, pnum, fecha, jobid, salary, comi, manid, depid);
			 
			 arrayempleado.add(empleado);
			 
			 
			 
			 
			}   
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		}   
		for (int i = 0; i < arrayempleado.size(); i++) {
			
			System.out.println(arrayempleado.get(i).toString());
			
		}
	}

}

