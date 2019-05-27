package mycompra.app.controlador;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mycompra.app.R;
import mycompra.app.adaptersRecycler.AdapterNevera;
import mycompra.app.adaptersRecycler.RecyclerItemClickListener;
import mycompra.app.dao.ProductoDAO;
import mycompra.app.modelo.Producto;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nevera extends Fragment {

    ArrayList<String> listCantidad;
    ArrayList<String> listProd;
    ArrayList<String> listCaducidad;
    RecyclerView recycler;
    ArrayList<Producto> listaProductos;

    public Nevera() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nevera, container, false);

        recycler = view.findViewById(R.id.RecyclerId);

        llenarLista();

        AdapterNevera adapter = new AdapterNevera(listCantidad, listProd, listCaducidad);

        recycler.setAdapter(adapter);

        recycler.setItemAnimator(new DefaultItemAnimator());

        recycler.addOnItemTouchListener(new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Bundle bundle = new Bundle();

                bundle.putString("fragmentAnterior", "Nevera");
                bundle.putString("idProducto", String.valueOf(listaProductos.get(position).getId()));

                DetalleProdInventario detalleProdInventario = new DetalleProdInventario();
                detalleProdInventario.setArguments(bundle);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, detalleProdInventario);
                ft.commit();
            }
        }));

        recycler.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler.getContext(),
                ((LinearLayoutManager) recycler.getLayoutManager()).getOrientation());
        recycler.addItemDecoration(dividerItemDecoration);

        FloatingActionButton buttonNuevoProdNevera = view.findViewById(R.id.buttonNuevoProdNevera);
        buttonNuevoProdNevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("fragmentAnterior", "Nevera");

                NuevoProducto nuevoProducto = new NuevoProducto();
                nuevoProducto.setArguments(bundle);

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame, nuevoProducto);
                fr.commit();
            }
        });
        return view;
    }

    private void llenarLista(){
        ProductoDAO productoDAO = new ProductoDAO(getActivity().getApplicationContext());

        listaProductos = productoDAO.getProductoListNevera();

        listCantidad = new ArrayList<String>();
        listProd = new ArrayList<String>();
        listCaducidad = new ArrayList<String>();

        for(int i = 0; i < listaProductos.size(); i++){
            listCantidad.add(String.valueOf(listaProductos.get(i).getCantidad()));
            listProd.add(listaProductos.get(i).getNombre());
            listCaducidad.add(listaProductos.get(i).getCaducidad());
        }
    }
}
