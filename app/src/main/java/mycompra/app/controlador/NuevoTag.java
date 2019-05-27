package mycompra.app.controlador;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mycompra.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NuevoTag extends Fragment {


    public NuevoTag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuevo_tag, container, false);
    }

}
