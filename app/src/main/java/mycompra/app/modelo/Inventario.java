package mycompra.app.modelo;

public class Inventario {

    public static final String TABLE = "Inventario";

    public static final String KEY_ID = "id";
    public static final String KEY_Nombre = "nombre";

    private int id;
    private String nombre;

    public Inventario(){
    }

    public Inventario(int id, String nombre){
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
