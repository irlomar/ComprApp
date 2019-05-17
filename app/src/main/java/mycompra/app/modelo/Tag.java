package mycompra.app.modelo;

public class Tag {

    public static final String TABLE = "Tag";

    public static final String KEY_ID = "id";
    public static final String KEY_Nombre = "nombre";
    public static final String KEY_ID_Categoria = "idCategoria";

    private int id;
    private String nombre;
    private int idCategoria;

    public Tag(){
    }

    public Tag(int id, String nombre, int idCategoria){
        this.id = id;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
