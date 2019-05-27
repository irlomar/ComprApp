package mycompra.app.controlador;

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
import android.widget.CheckBox;

import java.util.ArrayList;

import mycompra.app.R;
import mycompra.app.adaptersRecycler.AdapterListaHabitual;
import mycompra.app.controlador.NuevoProductoLista;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaHabitual extends Fragment {

    RecyclerView recycler;
    ArrayList<String> listCategoria;
    ArrayList<CheckBox> listCheckBox;

    public ListaHabitual() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_lista_habitual, container, false);

        recycler= vista.findViewById(R.id.RecyclerListaHabitualId);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterListaHabitual adapter = new AdapterListaHabitual(listCategoria,listCheckBox);

        recycler.setAdapter(adapter);


        FloatingActionButton eliminarProd = vista.findViewById(R.id.eliminarProducto_listaH);
        eliminarProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Eliminar producto", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        FloatingActionButton nuevoProdLista = vista.findViewById(R.id.nuevoProducto_listaH);
        nuevoProdLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame,new NuevoProductoLista());
                fr.commit();

            }
        });

        return vista;
    }

    private void llenarLista() {
        listCategoria = new ArrayList<String>();
        listCheckBox = new ArrayList<CheckBox>();

        for(int i = 0; i < 10; i++){
            listCategoria.add("Categoria" + i);
        }
    }
}
