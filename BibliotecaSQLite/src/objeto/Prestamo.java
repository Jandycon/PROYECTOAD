package objeto;

import java.sql.Date;

public class Prestamo {
	
	private String alumno;
	private String libro;
	private Date fechapres;
	private String fechastrpres;
	private Date fechadevol;
	private String fechastrdevol;
	private String estado;
	
	public Prestamo(String alumno, String libro, String fechastrpres, String fechastrdevol, String estado) {
		this.alumno=alumno;
		this.libro=libro;
		this.fechastrpres=fechastrpres;
		this.fechastrdevol=fechastrdevol;
		this.estado=estado;
	}
	
	public Prestamo(String alumno, String libro, Date fechapres, Date fechadevol, String estado) {
		this.alumno=alumno;
		this.libro=libro;
		this.fechapres=fechapres;
		this.fechadevol=fechadevol;
		this.estado=estado;
	}

	public String getFechastrdevol() {
		return fechastrdevol;
	}
	
	public String getFechastrpres() {
		return fechastrpres;
	}
	
	public String getAlumno() {
		return alumno;
	}

	public String getLibro() {
		return libro;
	}

	public Date getFechapres() {
		return fechapres;
	}

	public Date getFechadevol() {
		return fechadevol;
	}

	public String getEstado() {
		return estado;
	}
}
