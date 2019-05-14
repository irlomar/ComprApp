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
public class Despensa extends Fragment {

    ArrayList<String> listCantidadD;
    ArrayList<String> listProdD;
    ArrayList<String> listCaducidadD;
    RecyclerView recycler;

    public Despensa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_despensa, container, false);
        recycler= vista.findViewById(R.id.RecyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterNevera adapter = new AdapterNevera(listCantidadD,listProdD,listCaducidadD);

        recycler.setAdapter(adapter);

        FloatingActionButton buttonNuevoProdNevera = vista.findViewById(R.id.buttonNuevoProdDespensa);
        buttonNuevoProdNevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame,new NuevaLista());
                fr.commit();
            }
        });

        return vista;
    }


    private void llenarLista(){

        listCantidadD = new ArrayList<String>();
        listProdD = new ArrayList<String>();
        listCaducidadD = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            listCantidadD.add("N");
            listProdD.add("Producto" + i);
            listCaducidadD.add("Caducidad");
        }
    }

}
