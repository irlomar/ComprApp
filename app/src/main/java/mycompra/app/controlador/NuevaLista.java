package mycompra.app.controlador;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mycompra.app.R;
import mycompra.app.controlador.Listas;


/**
 * A simple {@link Fragment} subclass.
 */
public class NuevaLista extends Fragment {


    public NuevaLista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_nueva_lista, container, false);

        Button btnAceptar = (Button) vista.findViewById(R.id.buttonAceptarNuevaLista);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,new Listas());
                ft.commit();
            }

        });

        Button btnCancelar = (Button) vista.findViewById(R.id.buttonCancelarNuevaLista);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,new Listas());
                ft.commit();
            }

        });

        return vista;
    }

}
