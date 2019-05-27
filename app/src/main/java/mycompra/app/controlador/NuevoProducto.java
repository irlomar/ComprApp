package mycompra.app.controlador;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mycompra.app.R;
import mycompra.app.controlador.Productos;
import mycompra.app.dao.ProductoDAO;
import mycompra.app.modelo.Producto;


/**
 * A simple {@link Fragment} subclass.
 */
public class NuevoProducto extends Fragment {

    private ProductoDAO productoDAO;
    private String anteriorFragment;
    private EditText editTextNombre;

    public NuevoProducto() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_nuevo_producto, container, false);

        anteriorFragment = getArguments().getString("fragmentAnterior");

        productoDAO = new ProductoDAO(getActivity().getApplicationContext());

        Button btnAceptar = (Button) vista.findViewById(R.id.aceptarNuevoProducto);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                if (anteriorFragment.equalsIgnoreCase("nevera")) {
                    ft.replace(R.id.frame, new Nevera());
                }
                else {
                    ft.replace(R.id.frame, new Productos());
                }
                ft.commit();
            }

        });

        Button btnCancelar = (Button) vista.findViewById(R.id.cancelarNuevoProducto);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                if (anteriorFragment.equalsIgnoreCase("nevera")) {
                    ft.replace(R.id.frame, new Nevera());
                }
                else {
                    ft.replace(R.id.frame, new Productos());
                }
                ft.commit();
            }

        });

        Button btnAnyadir = vista.findViewById(R.id.btnAnyadirFragmentNuevoProducto);
        editTextNombre = vista.findViewById(R.id.editTextNombreNuevoProducto);

        btnAnyadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextNombre.getText().toString().equalsIgnoreCase("")) {
                    Producto producto = new Producto();
                    producto.setNombre(String.valueOf(editTextNombre.getText()));
                    producto.setIdInventario(2);
                    productoDAO.insert(producto);
                    editTextNombre.setText("");
                    Toast.makeText(getActivity().getApplicationContext(), "Producto añadido correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return vista;
    }

}
