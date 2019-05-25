package mycompra.app.logica;
import java.util.ArrayList;

import mycompra.app.modelo.Inventario;
import mycompra.app.modelo.Producto;

public class GestorInventario
{
    private static Inventario[] inventarios;
    private static ControlCaducidad caducidades;

    private static Inventario NEVERA;
    private static Inventario CONGELADOR;
    private static Inventario DESPENSA;

    public GestorInventario()
    {
        NEVERA = new Inventario();
        CONGELADOR = new Inventario();
        DESPENSA = new Inventario();

        inventarios = new Inventario[] {NEVERA, CONGELADOR, DESPENSA};
    }

    /*public boolean guardarProducto(Producto prod)
    {
        for (int i = 0; i < NEVERA.getCategorias().size(); i++)
        {
            if (prod.getIdCategoria() == NEVERA.getCategorias().get(i).getId())
            {
                NEVERA.putProducto(prod);
                return true;
            }
            else if (prod.getIdCategoria() == CONGELADOR.getCategorias().get(i).getId())
            {
                CONGELADOR.putProducto(prod);
                return true;
            }
            else if (prod.getIdCategoria() == DESPENSA.getCategorias().get(i).getId())
            {
                DESPENSA.putProducto(prod);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Producto> getProductos(Inventario inventario)
    {
        return inventario.getProductos();
    }*/
}
