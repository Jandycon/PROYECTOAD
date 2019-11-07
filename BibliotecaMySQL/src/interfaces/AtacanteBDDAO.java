package interfaces;

import java.util.ArrayList;

import objeto.Alumno;
import objeto.Devolucion;
import objeto.Libro;
import objeto.Prestamo;

public interface AtacanteBDDAO {
	//Interfaz para atacar a la base de datos
	public void agregarLibro(Libro libro);
	public void borrarLibro(Libro libro);
	public void actualizarLibro(Libro libro);
	public void actualizarEstadoLibro(Libro libro);
	public ArrayList<Libro> getAllLibros();
	
	public void agregarAlumno(Alumno alumno);
	public void borrarAlumno(Alumno alumno);
	public void actualizarAlumno(Alumno alumno);
	public ArrayList<Alumno> getAllAlumnos();		
	
	public void agregarPrestamo(Prestamo prestamo);
	public void borrarPrestamo(Prestamo prestamo);
	public ArrayList<Prestamo> getAllPrestamos();
	
	public void agregarDevolucion(Devolucion devolucion);
	public ArrayList<Devolucion> getAllDevoluciones();
}
