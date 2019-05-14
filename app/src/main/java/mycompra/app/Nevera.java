package mycompra.app;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class Nevera extends Fragment {

    ArrayList<String> listCantidad;
    ArrayList<String> listProd;
    ArrayList<String> listCaducidad;
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

        AdapterNevera adapter = new AdapterNevera(listCantidad,listProd,listCaducidad);

        recycler.setAdapter(adapter);
        FloatingActionButton buttonNuevoProdNevera = view.findViewById(R.id.buttonNuevoProdNevera);
        buttonNuevoProdNevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame,new NuevaLista());
                fr.commit();
            }
        });
        return view;
    }

    private void llenarLista(){

        listCantidad = new ArrayList<String>();
        listProd = new ArrayList<String>();
        listCaducidad = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            listCantidad.add("N");
            listProd.add("Producto" + i);
            listCaducidad.add("Caducidad");
        }
    }
}
