package mycompra.app;


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

import mycompra.app.dao.ProductoDAO;
import mycompra.app.modelo.Producto;


/**
 * A simple {@link Fragment} subclass.
 */
public class Despensa extends Fragment {

    ArrayList<String> listCantidadD;
    ArrayList<String> listProdD;
    ArrayList<String> listCaducidadD;
    RecyclerView recycler;
    ArrayList<Producto> listaProductos;

    public Despensa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_despensa, container, false);
        recycler = vista.findViewById(R.id.RecyclerId);

        llenarLista();

        AdapterDespensa adapter = new AdapterDespensa(listCantidadD, listProdD, listCaducidadD);

        recycler.setAdapter(adapter);

        recycler.setItemAnimator(new DefaultItemAnimator());

        recycler.addOnItemTouchListener(new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new Nuevo_producto_lista());
                ft.commit();
            }
        }));

        recycler.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler.getContext(),
                ((LinearLayoutManager) recycler.getLayoutManager()).getOrientation());
        recycler.addItemDecoration(dividerItemDecoration);

        FloatingActionButton buttonNuevoProdNevera = vista.findViewById(R.id.buttonNuevoProdDespensa);
        buttonNuevoProdNevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame, new NuevaLista());
                fr.commit();
            }
        });

        return vista;
    }


    private void llenarLista(){
        ProductoDAO productoDAO = new ProductoDAO(getActivity().getApplicationContext());

        listaProductos = productoDAO.getProductoListDespensa();

        listCantidadD = new ArrayList<String>();
        listProdD = new ArrayList<String>();
        listCaducidadD = new ArrayList<String>();

        for(int i = 0; i < listaProductos.size(); i++){
            listCantidadD.add(String.valueOf(listaProductos.get(i).getCantidad()));
            listProdD.add(listaProductos.get(i).getNombre());
            listCaducidadD.add(listaProductos.get(i).getCaducidad());
        }
    }

}
