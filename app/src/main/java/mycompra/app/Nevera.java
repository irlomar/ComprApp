package mycompra.app;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nevera extends Fragment {

    ArrayList<String> listDatos;
    ArrayList<String> listProd;
    ArrayList<String> listCat;
    RecyclerView recycler;

    public Nevera() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nevera, container, false);
        recycler= view.findViewById(R.id.RecyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterNevera adapter = new AdapterNevera(listDatos,listProd,listCat);

        recycler.setAdapter(adapter);


        FloatingActionButton eliminar_prodNevera = view.findViewById(R.id.eliminarProducto_nevera);
        eliminar_prodNevera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /*Snackbar.make(view, "Eliminar producto", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        return view;
    }

    private void llenarLista(){

        listDatos = new ArrayList<String>();
        listProd = new ArrayList<String>();
        listCat = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            listDatos.add("M");
            listProd.add("Producto" + i);
            listCat.add("Categoria" + i);
        }
    }
}
