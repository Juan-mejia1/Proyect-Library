import java.util.ArrayList;
import java.util.Locale;

public class Biblioteca {
	private final ArrayList<Libro> libros = new ArrayList<>();
	private String ultimoError = "";

	public boolean agregarLibro(Libro libro) {
		limpiarError();
		if (buscarPorCodigo(libro.getCodigo()) != null) {
			return false;
		}
		libros.add(libro);
		return true;
	}

	public ArrayList<Libro> obtenerTodos() {
		limpiarError();
		return new ArrayList<>(libros);
	}

	public boolean eliminarLibro(String codigo) {
		limpiarError();
		Libro libro = buscarPorCodigo(codigo);
		return libro != null && libros.remove(libro);
	}

	public boolean actualizarLibro(Libro libroActualizado) {
		limpiarError();
		Libro libro = buscarPorCodigo(libroActualizado.getCodigo());
		if (libro == null) {
			return false;
		}
		libro.setTitulo(libroActualizado.getTitulo());
		libro.setAutor(libroActualizado.getAutor());
		libro.setGenero(libroActualizado.getGenero());
		libro.setAnioPublicacion(libroActualizado.getAnioPublicacion());
		libro.setCopiasDisponibles(libroActualizado.getCopiasDisponibles());
		return true;
	}

	public ArrayList<Libro> buscarPorTitulo(String titulo) {
		limpiarError();
		return buscarPorTexto(titulo, true);
	}

	public ArrayList<Libro> filtrarPorAutor(String autor) {
		limpiarError();
		return buscarPorTexto(autor, false);
	}

	private ArrayList<Libro> buscarPorTexto(String texto, boolean porTitulo) {
		String consulta = texto.toLowerCase(Locale.ROOT);
		ArrayList<Libro> resultados = new ArrayList<>();
		for (Libro libro : libros) {
			String valor = porTitulo ? libro.getTitulo() : libro.getAutor();
			if (valor.toLowerCase(Locale.ROOT).contains(consulta)) {
				resultados.add(libro);
			}
		}
		return resultados;
	}

	public int contarLibrosDisponibles() {
		limpiarError();
		int total = 0;
		for (Libro libro : libros) {
			total += libro.getCopiasDisponibles();
		}
		return total;
	}

	public String getUltimoError() {
		return ultimoError;
	}

	private Libro buscarPorCodigo(String codigo) {
		for (Libro libro : libros) {
			if (libro.getCodigo().equalsIgnoreCase(codigo)) {
				return libro;
			}
		}
		return null;
	}

	private void limpiarError() {
		ultimoError = "";
	}
}
