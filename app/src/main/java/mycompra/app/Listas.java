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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Listas extends Fragment {

    ArrayList<String> nombreListas;
    RecyclerView recyclerView;

    public Listas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_listas, container, false);

        recyclerView= vista.findViewById(R.id.RecyclerIdListas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListas();

        AdapterListas adapter = new AdapterListas(nombreListas);

        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame,new ListaHabitual());
                fr.commit();
            }
        });

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
