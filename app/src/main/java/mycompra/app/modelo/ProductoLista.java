package mycompra.app.modelo;

public class ProductoLista {
    public static final String TABLE = "ProductoLista";

    public static final String KEY_ID_Producto = "idProducto";
    public static final String KEY_ID_Lista = "idLista";

    private int idProducto;
    private int idLista;

    public ProductoLista(){
    }

    public ProductoLista(int idProducto, int idLista){
        this.idProducto = idProducto;
        this.idLista = idLista;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }
}
