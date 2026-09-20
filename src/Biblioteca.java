import java.util.ArrayList; //para crear la lista de los libros
import java.util.HashMap; // esto para poder filtrar los libros por el autor, guarda la infoamcion de la clave y un valor
import java.util.HashSet; // este para validad si algun codigo esta repetido , evitar ingresar 2 veces el mismo libro

public class Biblioteca {

    //==ATRIBUTOS==
    //(Colecciones)
    private ArrayList<Libro> listaLibros; //Aqui basicamente se declara una lista que guarda solo objetos tipo libro
    private HashSet<String> codigoRegistrado; //para almacenar y evitar duplicar el codigo tipo String
    private HashMap<String, ArrayList<Libro>> indiceAutor ; // clave (String autor) valor (objeto Libro) representada como indiceAutor


    //==CONSTRUCTOR==
    //Aqui las colecciones se inicializan vacias para que cuando se abra la aplicacion
    //el construccor ejecute autometicamente las listas para poder recibir datos
    public Biblioteca(){
        this.listaLibros = new ArrayList<>();//
        this.codigoRegistrado=new HashSet<>();
        this.indiceAutor=new HashMap<>();
        
    }

}
