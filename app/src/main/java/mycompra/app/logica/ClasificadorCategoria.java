package com.example.comprapp.logica;

import com.example.comprapp.dao.CategoriaDAO;
import com.example.comprapp.modelo.Categoria;
import com.example.comprapp.modelo.Producto;

import java.util.ArrayList;

public class ClasificadorCategoria {
    //private Categoria tags;
    private CategoriaDAO categoriaDAO;

    private static ArrayList<Categoria> categorias;

    public ClasificadorCategoria(){
        categoriaDAO = new CategoriaDAO();
        //tags = new Tags();
        categorias = categoriaDAO.getCategoriaList();
    }


    public Categoria findCategoria(Producto producto) {
        String prodName = producto.getNombre();

        for (int i = 0; i < categorias.size(); i++) // Recorre categorias
        {
            int numTags = categorias.get(i).getTags().size();
            Categoria categoriaActual = categorias.get(i);

            for (int j = 0; j < numTags; j++) // Recorre tags de la categoria actual
            {
                if (categoriaActual.getTags().get(i).contains(prodName)) {
                    return categoriaActual;
                }
            }
        }

        return null;
    }
}
