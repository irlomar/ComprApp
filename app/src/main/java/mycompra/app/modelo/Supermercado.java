package mycompra.app.modelo;

public class Supermercado {

    public static final String TABLE = "Supermercado";

    public static final String KEY_ID = "id";
    public static final String KEY_Nombre = "nombre";

    private int id;
    private String nombre;

    public Supermercado(){
    }

    public Supermercado(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
