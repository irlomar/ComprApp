package mycompra.app.logica;

import java.util.ArrayList;

import mycompra.app.dao.CategoriaDAO;
import mycompra.app.modelo.Categoria;
import mycompra.app.modelo.Producto;

public class ClasificadorCategoria {
    //private Categoria tags;
    private CategoriaDAO categoriaDAO;

    private static ArrayList<Categoria> categorias;

    public ClasificadorCategoria(){
        //categoriaDAO = new CategoriaDAO();
        //tags = new Tags();
        categorias = categoriaDAO.getCategoriaList();
    }


    public Categoria findCategoria(Producto producto) {
        String prodName = producto.getNombre();

        /*for (int i = 0; i < categorias.size(); i++) // Recorre categorias
        {
            int numTags = categorias.get(i).getTags().size();
            Categoria categoriaActual = categorias.get(i);

            for (int j = 0; j < numTags; j++) // Recorre tags de la categoria actual
            {
                if (categoriaActual.getTags().get(i).contains(prodName)) {
                    return categoriaActual;
                }
            }
        }*/

        return null;
    }
}