package mycompra.app.modelo;

public class ProductoTicket {
    public static final String TABLE = "ProductoTicket";

    public static final String KEY_ID_Producto = "idProducto";
    public static final String KEY_ID_Ticket = "idTicket";
    public static final String KEY_Cantidad = "cantidad";

    private int idProducto;
    private int idTicket;
    private int cantidad;

    public ProductoTicket(){
    }

    public ProductoTicket(int idProducto, int idTicket, int cantidad){
        this.idProducto = idProducto;
        this.idTicket = idTicket;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
