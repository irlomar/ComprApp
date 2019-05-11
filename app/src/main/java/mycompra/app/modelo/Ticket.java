package mycompra.app.modelo;

public class Ticket {

    public static final String TABLE = "Ticket";

    public static final String KEY_ID = "id";
    public static final String KEY_Precio = "precio";
    public static final String KEY_Fecha = "fecha";
    public static final String KEY_ID_Supermercado = "idSupermercado";
    public static final String KEY_ID_Mes = "idMes";

    private int id;
    private double precio;
    private String fecha;
    private int idSupermercado;
    private int idMes;

    public Ticket(){
    }

    public Ticket(int id, double precio, String fecha, int idSupermercado, int idMes){
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
        this.idSupermercado = idSupermercado;
        this.idMes = idMes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(int idSupermercado) {
        this.idSupermercado = idSupermercado;
    }

    public int getIdMes() {
        return idMes;
    }

    public void setIdMes(int idMes) {
        this.idMes = idMes;
    }
}
