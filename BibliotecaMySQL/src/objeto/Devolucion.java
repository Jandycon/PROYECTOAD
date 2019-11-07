package objeto;

import java.sql.Date;

public class Devolucion {

	private String libro;
	private String alumno;
	private Date fechadevol;
	private String fechastrdev;
	private String estado;
	
	public Devolucion(String libro, String alumno, Date fechadevol, String estado) {
		this.libro = libro;
		this.alumno = alumno;
		this.fechadevol = fechadevol;
		this.estado = estado;
	}
	
	public Devolucion(String libro, String alumno, String fechastrdev, String estado) {
		this.libro = libro;
		this.alumno = alumno;
		this.fechastrdev = fechastrdev;
		this.estado = estado;
	}
	
	public String getFechastrdev() {
		return fechastrdev;
	}
	
	public String getLibro() {
		return libro;
	}
	
	public String getAlumno() {
		return alumno;
	}
	
	public Date getFechadevol() {
		return fechadevol;
	}
	
	public String getEstado() {
		return estado;
	}
}
