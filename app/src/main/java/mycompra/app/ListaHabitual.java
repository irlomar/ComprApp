package mycompra.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaHabitual extends Fragment {

    public ListaHabitual() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_lista_habitual, container, false);
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
                Snackbar.make(view, "Añadir producto", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        return vista;
    }
}
