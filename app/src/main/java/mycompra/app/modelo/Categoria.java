package mycompra.app.modelo;

public class Categoria {

    public static final String TABLE = "Categoria";

    public static final String KEY_ID = "id";
    public static final String KEY_Nombre = "nombre";
    public static final String KEY_ID_Inventario = "idInventario";

    private int id;
    private String nombre;
    private int idInventario;

    public Categoria(){
    }

    public Categoria(int id, String nombre, int idInventario){
        this.id = id;
        this.nombre = nombre;
        this.idInventario = idInventario;
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

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }
}
