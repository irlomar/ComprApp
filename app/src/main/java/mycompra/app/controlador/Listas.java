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
import mycompra.app.adaptersRecycler.AdapterListas;


/**
 * A simple {@link Fragment} subclass.
 */
public class Listas extends Fragment {

    ArrayList<String> nombreListas;
    RecyclerView recyclerListas;

    public Listas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_listas, container, false);

        recyclerListas = vista.findViewById(R.id.RecyclerIdListas);
        recyclerListas.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListas();

        AdapterListas adapter = new AdapterListas(nombreListas);

        recyclerListas.setAdapter(adapter);


        FloatingActionButton buttonNuevaLista = vista.findViewById(R.id.buttonNuevaLista);
        buttonNuevaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame,new NuevaLista());
                fr.commit();
            }
        });
        return vista;
    }

    private void llenarListas() {
        nombreListas = new ArrayList<String>();

            nombreListas.add("Lista Habitual");
            nombreListas.add("Lista Customizada");
            nombreListas.add("Lista Compartida" );

    }

}
