package mycompra.app.controlador;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mycompra.app.R;
import mycompra.app.dao.ProductoDAO;
import mycompra.app.modelo.Producto;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleProdInventario extends Fragment {

    private Producto producto;
    private String idProducto;
    private String anteriorFragment;
    private ProductoDAO productoDAO;
    private EditText editTextPrecio;
    private EditText editTextCantidad;
    private EditText editTextCaducidad;
    private TextView textViewInventario;
    private TextView textViewNombre;
    private Button btnBorrar;
    private Button btnActualizar;

    public DetalleProdInventario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_prod_inventario, container, false);

        editTextPrecio = view.findViewById(R.id.editTextPrecioDetalle);
        editTextCantidad = view.findViewById(R.id.textViewCantidadDetalle);
        editTextCaducidad = view.findViewById(R.id.editTextCaducidadDetalle);
        textViewNombre = view.findViewById(R.id.textNombreProductoFragmentDetalle);
        textViewInventario = view.findViewById(R.id.textViewInventarioDetalle);

        idProducto = getArguments().getString("idProducto");
        anteriorFragment = getArguments().getString("fragmentAnterior");

        productoDAO = new ProductoDAO(getActivity().getApplicationContext());

        producto = productoDAO.getProductoById(Integer.valueOf(idProducto));

        textViewNombre.setText(producto.getNombre());
        editTextPrecio.setText(String.valueOf(producto.getPrecio()));
        editTextCantidad.setText(String.valueOf(producto.getCantidad()));
        if (producto.getCaducidad() != null) {
            editTextCaducidad.setText(producto.getCaducidad());
        }
        switch (producto.getIdInventario()){
            case 1 :
                textViewInventario.setText("Despensa");
                break;
            case 2:
                textViewInventario.setText("Nevera");
                break;
            case 3:
                textViewInventario.setText("Congelador");
                break;
            default:
                textViewInventario.setText("");
        }

        btnBorrar = view.findViewById(R.id.btnBorrarDetalle);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productoDAO.delete(producto.getId());
                devolverAFragmentAnterior();
            }
        });

        btnActualizar = view.findViewById(R.id.btnActualizarDetalle);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextPrecio.getText().toString().equalsIgnoreCase("")) {
                    producto.setPrecio(Double.parseDouble(editTextPrecio.getText().toString()));
                }
                if (!editTextCantidad.getText().toString().equalsIgnoreCase("") && !editTextCantidad.getText().toString().equalsIgnoreCase("0")) {
                    producto.setCantidad(Integer.parseInt(editTextCantidad.getText().toString()));
                }
                if (!editTextCaducidad.getText().toString().equalsIgnoreCase("")) {
                    producto.setCaducidad(editTextCaducidad.getText().toString());
                }
                productoDAO.update(producto);
                devolverAFragmentAnterior();
            }
        });

        return view;
    }

    private void devolverAFragmentAnterior() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (anteriorFragment.equalsIgnoreCase("nevera")) {
            ft.replace(R.id.frame, new Nevera());
        }
        else {
            ft.replace(R.id.frame, new Productos());
        }
        ft.commit();
    }

}
