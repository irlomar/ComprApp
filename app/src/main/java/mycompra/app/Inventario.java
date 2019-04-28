package mycompra.app;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Inventario extends Fragment {

    Nevera nevera;
    NuevoInventario nuevoInventario;

    public Inventario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_inventario, container, false);
        FloatingActionButton fab = vista.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Nuevo inventario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                /*nuevoInventario = new NuevoInventario();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, nuevoInventario, "Nuevo inventario");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
            }
        });
        return vista;
    }

        //no funciona
    public void OnClickNevera(View view){

        /*nevera = new Nevera();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, nevera, "Nuevo inventario").addToBackStack(null).commit();*/
    }
}
