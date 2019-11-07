package objeto;

public class Alumno {

	private String dni, nombre, ape1, ape2;
	
	public Alumno(String dni, String nombre, String ape1, String ape2) {
		this.dni=dni;
		this.nombre=nombre;
		this.ape1=ape1;
		this.ape2=ape2;	
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}
}
