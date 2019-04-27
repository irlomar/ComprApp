package mycompra.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Productos extends Fragment {

    ArrayList<String> listDatosProd;
    ArrayList<String> listProduct;
    ArrayList<String> listCatProd;
    RecyclerView recyclerView;

    public Productos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        recyclerView= view.findViewById(R.id.RecyclerIdProd);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaProd();

        AdapterProductos adapter = new AdapterProductos(listDatosProd,listProduct,listCatProd);

        recyclerView.setAdapter(adapter);
        return view;
    }

    private void llenarListaProd() {
        listDatosProd = new ArrayList<String>();
        listProduct = new ArrayList<String>();
        listCatProd = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            listDatosProd.add("M");
            listProduct.add("Producto" + i);
            listCatProd.add("Categoria" + i);
        }
    }

}
