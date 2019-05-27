package mycompra.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nuevo_producto_lista extends Fragment {


    public Nuevo_producto_lista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_nuevo_producto_lista, container, false);

        Button btnAceptar = (Button) vista.findViewById(R.id.aceptarNuevoProdLista);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,new ListaHabitual());
                ft.commit();
            }

        });

        Button btnCancelar = (Button) vista.findViewById(R.id.cancelarNuevoProdLista);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,new ListaHabitual());
                ft.commit();
            }

        });
        return vista;
    }

}
