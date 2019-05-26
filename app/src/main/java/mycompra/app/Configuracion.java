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
public class Configuracion extends Fragment {


    public Configuracion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_configuracion, container, false);

        Button btnNuevaCategoria = (Button) vista.findViewById(R.id.buttonNuevaCat);
        btnNuevaCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,new NuevaCategoria());
                ft.commit();
            }
        });

        Button btnNuevaTag = (Button) vista.findViewById(R.id.buttonNuevaTag);
        btnNuevaTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,new NuevoTag());
                ft.commit();
            }
        });

        return vista;
    }

}
