package interfaces;

import java.util.ArrayList;

import objeto.Alumno;

public interface AlumnoDAO {
	public void agregarAlumno(Alumno alumno);
	public void borrarAlumno(Alumno alumno);
	public void actualizarAlumno(Alumno alumno);
	public ArrayList<Alumno> getAllAlumnos();	
}
