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
public class Congelador extends Fragment {

    ArrayList<String> listCantidadC;
    ArrayList<String> listProdC;
    ArrayList<String> listCaducidadC;
    RecyclerView recycler;

    public Congelador() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_congelador, container, false);

        recycler= view.findViewById(R.id.RecyclerIdCongelador);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterCongelador adapter = new AdapterCongelador(listCantidadC,listProdC,listCaducidadC);

        recycler.setAdapter(adapter);
        FloatingActionButton buttonNuevoProdNevera = view.findViewById(R.id.buttonNuevoProdCongelador);
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

        listCantidadC = new ArrayList<String>();
        listProdC = new ArrayList<String>();
        listCaducidadC = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            listCantidadC.add("N");
            listProdC.add("Producto" + i);
            listCaducidadC.add("Caducidad");
        }
    }

}
