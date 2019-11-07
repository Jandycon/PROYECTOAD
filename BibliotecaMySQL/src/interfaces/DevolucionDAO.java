package interfaces;

import java.util.ArrayList;
import objeto.Devolucion;

public interface DevolucionDAO {
	public void agregarDevolucion(Devolucion devolucion);
	public ArrayList<Devolucion> getAllDevoluciones();
}
