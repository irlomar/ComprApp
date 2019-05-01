package mycompra.app;


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
public class Listas extends Fragment {


    public Listas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_listas, container, false);
        FloatingActionButton buttonNuevaLista = vista.findViewById(R.id.buttonNuevaLista);
        buttonNuevaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Nueva lista", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                /*nuevaLista = new NuevaLista();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, nuevaLista, "Nueva Lista");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
            }
        });
        return vista;
    }

}
