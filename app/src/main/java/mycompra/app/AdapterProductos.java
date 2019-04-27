package mycompra.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.ViewHolderProductos> {

    ArrayList<String> listDatosProd;
    ArrayList<String> listProduct;
    ArrayList<String> listCatProd;

    public AdapterProductos(ArrayList<String> listDatosProd, ArrayList<String> listProduct, ArrayList<String> listCatProd) {
        this.listDatosProd = listDatosProd;
        this.listProduct = listProduct;
        this.listCatProd = listCatProd;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.productos_list,null,false);

        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos viewHolderProductos, int i) {
        viewHolderProductos.asignarDatos(listDatosProd.get(i),listProduct.get(i),listCatProd.get(i));
    }

    @Override
    public int getItemCount() {
        return listDatosProd.size();
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {

        TextView datosProd;
        TextView productos;
        TextView categoria;

        public ViewHolderProductos(@NonNull View itemView) {
            super(itemView);
            datosProd = itemView.findViewById(R.id.idDatos);
            productos = itemView.findViewById(R.id.idDatoProducto);
            categoria = itemView.findViewById(R.id.idDatoCategoriaProducto);
        }

        public void asignarDatos(String s, String s1, String s2) {
            datosProd.setText(s);
            productos.setText(s1);
            categoria.setText(s2);
        }
    }
}
