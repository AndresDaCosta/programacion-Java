package dtoydao;

import java.sql.Date;

public class EmpleadoDTO {

	private int id;	
	private String fnombre;
	private String snombre;
	private String email;
	private String pnum;
	private Date fecha;
	private String jobid;
	private int salary;
	private float comi;
	private int manid;
	private int depid;
	
	public EmpleadoDTO(int id, String fnombre, String snombre, String email,
			String pnum, Date fecha, String jobid, int salary, float comi,
			int manid, int depid) {
		
		this.id = id;
		this.fnombre = fnombre;
		this.snombre = snombre;
		this.email = email;
		this.pnum = pnum;
		this.fecha = fecha;
		this.jobid = jobid;
		this.salary = salary;
		this.comi = comi;
		this.manid = manid;
		this.depid = depid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFnombre() {
		return fnombre;
	}

	public void setFnombre(String fnombre) {
		this.fnombre = fnombre;
	}

	public String getSnombre() {
		return snombre;
	}

	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public float getComi() {
		return comi;
	}

	public void setComi(float comi) {
		this.comi = comi;
	}

	public int getManid() {
		return manid;
	}

	public void setManid(int manid) {
		this.manid = manid;
	}

	public int getDepid() {
		return depid;
	}

	public void setDepid(int depid) {
		this.depid = depid;
	}
	@Override 
	public String toString(){
		return "soy " + fnombre + " " +  snombre + " tengo " + id + " mi email es  " + email + "\n" + " mi numero es  " + pnum + "\n"
				+ " entre en " + fecha + " trabajo en  " + jobid + " en el departamento  " + depid + " mi jefe es  " +
				manid + "\n" + " gano  " + salary + " con una comision de   " + comi;
	}
	
}

	
	

