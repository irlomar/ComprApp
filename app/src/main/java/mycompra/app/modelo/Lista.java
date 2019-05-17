package mycompra.app.modelo;

public class Lista {

    public static final String TABLE = "Lista";

    public static final String KEY_ID = "id";
    public static final String KEY_Nombre = "nombre";

    private int id;
    private String nombre;

    public Lista(){
    }

    public Lista(int id, String nombre){
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
