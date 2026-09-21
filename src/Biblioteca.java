import java.util.ArrayList; //para crear la lista de los libros
import java.util.HashMap; // esto para poder filtrar los libros por el autor, lo que hace es que crea una clave y toma el atributo del objeto como valor
import java.util.HashSet; // este para validar si algun codigo esta repetido , evitar ingresar 2 veces el mismo libro

public class Biblioteca {

    //==ATRIBUTOS==
    //(Colecciones)
    private ArrayList<Libro> listaLibros; //Aqui basicamente se declara una lista que guarda solo objetos tipo libro
    private HashSet<String> codigoRegistrado; //para almacenar y evitar duplicar el codigo tipo String
    private HashMap<String, ArrayList<Libro>>indiceAutor; // clave (String autor) valor (objeto Libro) representada como indiceAutor


    //==CONSTRUCTOR==
    //Aqui las colecciones se inicializan vacias para que cuando se abra la aplicacion
    //el construccor ejecute autometicamente las listas para poder recibir datos
    public Biblioteca() {
        this.listaLibros = new ArrayList<>();//
        this.codigoRegistrado = new HashSet<>();
        this.indiceAutor = new HashMap<>();

    }

    //==METODO AGREGAR LIBRO==
    public boolean agregarLibro(Libro libroNuevo) {
        //primero validar si el codigo del lirbo ya existe en el sistema
        //utilizamos el metodo .contains verifica si una serie de caracteres ya exsite dentro de un String o un coleccion
        if (codigoRegistrado.contains(libroNuevo.getCodigo())) {
            return false;//con el metodo .contains se verifica si el codigo registrado ya existe entonces retorna falso e impide que se agregue
        }
        //Si no esta duplicado entonces ignora el return y se agrega a la lista
        listaLibros.add(libroNuevo);// //se almacena en el array llamada listaLibros
        codigoRegistrado.add(libroNuevo.getCodigo()); //se agrega el codigo del libro al HasgSet de cdigos registrados

        // esta variable se crea para evitar que se creen diferentes entradas para un mismo autor, ya que el autor se puede ingresar en minusculas, mausculas y con espacios
        //para esto se utliza el getter, obtenemos el nombre del autor y con .toLower se convierte a minusculas
        // Y con .trim elimina los espacios en blanco al inicio y al final del nombre
        // el HashMap toma esta variable como la clave y el autor como el valor
        String autorNormalizado = libroNuevo.getAutor().toLowerCase().trim();

        // indiceAutor es donde esta la lista que crea el HashMap para los nombres de los autores
        //aqui se valida con el metodo .putIfAbsent si la clave existe dentro de la lista
        //este metodo se puede interpretar como: colocar si esta aunsente
        //en este caso revisa si la clave autorNormalizado existe, si existe no hace nada, si no existe crea una lista vacia y la asgina a ese autor
        indiceAutor.putIfAbsent(autorNormalizado, new ArrayList<>());
        indiceAutor.get(autorNormalizado).add(libroNuevo); // aquí agregamos el libro a la lista de ese autor

        return true; // se agregó
    }
}