package mycompra.app.controlador;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mycompra.app.R;
import mycompra.app.adaptersRecycler.AdapterProductos;
import mycompra.app.dao.CategoriaDAO;
import mycompra.app.dao.ProductoDAO;
import mycompra.app.modelo.Categoria;
import mycompra.app.modelo.Producto;


/**
 * A simple {@link Fragment} subclass.
 */
public class Productos extends Fragment {

    ArrayList<String> listDatosProd;
    ArrayList<String> listProduct;
    ArrayList<String> listCatProd;
    RecyclerView recyclerView;
    ArrayList<Producto> listaProductos;

    public Productos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        recyclerView = view.findViewById(R.id.RecyclerIdProd);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaProd();

        AdapterProductos adapter = new AdapterProductos(listDatosProd,listProduct,listCatProd);

        recyclerView.setAdapter(adapter);

        FloatingActionButton buttonNuevosPoductos = view.findViewById(R.id.buttonNuevoProducto_prod);
        buttonNuevosPoductos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                bundle.putString("fragmentAnterior", "Productos");

                NuevoProducto nuevoProducto = new NuevoProducto();
                nuevoProducto.setArguments(bundle);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, nuevoProducto);
                ft.commit();
            }
        });

        return view;
    }

    private void llenarListaProd() {
        ProductoDAO productoDAO = new ProductoDAO(getActivity().getApplicationContext());
        CategoriaDAO categoriaDAO = new CategoriaDAO(getActivity().getApplicationContext());

        ArrayList<Categoria> listaCategorias = categoriaDAO.getCategoriaList();

        listaProductos = productoDAO.getProductoList();

        listDatosProd = new ArrayList<String>();
        listProduct = new ArrayList<String>();
        listCatProd = new ArrayList<String>();

        for(int i = 0; i < listaProductos.size(); i++){
            listDatosProd.add(String.valueOf(listaProductos.get(i).getCantidad()));
            listProduct.add(listaProductos.get(i).getNombre());
            if (listaProductos.get(i).getIdCategoria() != 0) {
                listCatProd.add(listaCategorias.get(listaProductos.get(i).getIdCategoria() - 1).getNombre());
            }
            else {
                listCatProd.add("Sin categoria");
            }
        }
    }
}
