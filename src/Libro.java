public class Libro {

    //=CREACION DE ATRIBUTOS==
    //encapsulamiento usando "Private"
    private String titulo;
    private String autor;
    private String genero;
    private String codigo;
    private  int anio;
    private int copias;

    //==CONSTRUCTOR==
    public Libro(String titulo, String autor, String genero, String codigo, int anio,int copias){

        //Aqui conectamos los atributos con los parametros
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.codigo = codigo;
        this.anio = anio;
        this.copias = copias;
    }

    // se crea un metodo getter para leer u obtener los valores de cada atributo
    //en este caso se obtine el titulo del libro
    public String getTitulo(String titulo){
        return titulo;
    }
    //Metodo setter para asignar y modificar los valores en los atributos
    public void setTitulo(String titulo){
        this.titulo= titulo;
    }

    public String getAutor(String autor){
        return autor;
    }
    public void setAutor(String autor){
        this.autor= autor;
    }

    public String getGenero(String genero){
        return genero;
    }
    public void setGenero(String genero){
        this.genero= genero;
    }

    public String getCodigo(String codigo){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }

    public int getAnio(int anio){
        return anio;
    }
    public void setAnio(int anio){
        this.anio=anio;
    }

    public int getCopias(int copias){
        return copias;
    }
    public void setCopias(int copias){
        this.copias=copias;
    }


}
