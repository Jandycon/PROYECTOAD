package interfaces;

import java.util.ArrayList;

import objeto.Libro;

public interface LibroDAO {	
	public void agregarLibro(Libro libro);
	public void borrarLibro(Libro libro);
	public void actualizarLibro(Libro libro);
	public void actualizarEstadoLibro(Libro libro);
	public ArrayList<Libro> getAllLibros();
}
