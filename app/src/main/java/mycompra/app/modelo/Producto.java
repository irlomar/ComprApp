package mycompra.app.modelo;

public class Producto {

    public static final String TABLE = "Producto";

    public static final String KEY_ID = "id";
    public static final String KEY_Nombre = "nombre";
    public static final String KEY_Precio = "precio";
    public static final String KEY_Caducidad = "caducidad";
    public static final String KEY_Cantidad = "cantidad";
    public static final String KEY_ID_Inventario = "idInventario";
    public static final String KEY_ID_Categoria = "idCategoria";

    private int id;
    private String nombre;
    private double precio;
    private String caducidad;
    private int cantidad;
    private int idInventario;
    private int idCategoria;

    public Producto(){
    }

    public Producto(int id, String nombre, double precio, String caducidad, int cantidad, int idInventario, int idCategoria){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.caducidad = caducidad;
        this.cantidad = cantidad;
        this.idInventario = idInventario;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
