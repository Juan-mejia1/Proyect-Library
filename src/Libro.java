public class Libro extends MaterialBibliografico {
    private int copiasDisponibles;

    public Libro(String titulo, String autor, String codigo, String genero, int anioPublicacion,
            int copiasDisponibles) {
        super(titulo, autor, codigo, genero, anioPublicacion);
        this.copiasDisponibles = copiasDisponibles;
    }

    @Override
    public String getTipoMaterial() {
        return "Libro";
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    public int getCopias() {
        return copiasDisponibles;
    }

    public void setCopias(int copias) {
        this.copiasDisponibles = copias;
    }
}
