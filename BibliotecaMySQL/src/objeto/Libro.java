package objeto;

public class Libro {
	
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private String asignatura;
	private String estado;
	
	public Libro(String isbn,String titulo, String autor, String editorial, String asignatura, String estado) {
		this.isbn=isbn;
		this.titulo=titulo;
		this.autor=autor;
		this.editorial=editorial;
		this.asignatura=asignatura;
		this.estado=estado;
	}
	
	public Libro(String isbn,String estado) {
		this.isbn=isbn;
		this.estado=estado;
	}
	
	public String getIsbn() {
		return isbn;
	}	
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public String getEstado() {
		return estado;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
}
