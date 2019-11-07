package interfaces;

import java.util.ArrayList;
import objeto.Prestamo;

public interface PrestamoDAO {
	public void agregarPrestamo(Prestamo prestamo);
	public void borrarPrestamo(Prestamo prestamo);
	public ArrayList<Prestamo> getAllPrestamos();
}
