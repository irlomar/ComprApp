package mycompra.app.controlador;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mycompra.app.R;
import mycompra.app.controlador.Escanear;
import mycompra.app.controlador.Inventarios;
import mycompra.app.controlador.Listas;


/**
 * A simple {@link Fragment} subclass.
 */
public class Principal extends Fragment {


    public Principal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_principal, container, false);

        Button btnListasPrincipal = (Button) vista.findViewById(R.id.btnListPrincipalId);
        btnListasPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new Listas());
                ft.commit();
            }
        });

        Button btnEscanerPrincial = (Button) vista.findViewById(R.id.btnEscPrincId);
        btnEscanerPrincial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new Escanear());
                ft.commit();
            }
        });

        Button btnInventarioPrincipal = (Button) vista.findViewById(R.id.btnInventPrincId);
        btnInventarioPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().setTitle("Inventarios");
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new Inventarios());
                ft.commit();
            }
        });

        return vista;
    }

}
