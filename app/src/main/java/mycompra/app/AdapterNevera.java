package mycompra.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterNevera extends RecyclerView.Adapter<AdapterNevera.ViewHolderNevera> {

    ArrayList<String> listDatos;
    ArrayList<String> listProd;
    ArrayList<String> listCat;

    public AdapterNevera(ArrayList<String> listDatos, ArrayList<String> listProd, ArrayList<String> listCat) {
        this.listDatos = listDatos;
        this.listProd = listProd;
        this.listCat = listCat;
    }

    @Override
    public ViewHolderNevera onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.productos_nevera_list,null,false);
        return new ViewHolderNevera(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNevera viewHolderNevera, int i) {
        viewHolderNevera.asignarDatos(listDatos.get(i),listProd.get(i),listCat.get(i));
    }

    @Override
    public int getItemCount() {
        return listProd.size();
    }

    public class ViewHolderNevera extends RecyclerView.ViewHolder {

        TextView dato;
        TextView product;
        TextView cat;

        public ViewHolderNevera(@NonNull View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.idDato);
            product = itemView.findViewById(R.id.idDatoProductoNevera);
            cat = itemView.findViewById(R.id.idDatoCategoriaNevera);
        }

        public void asignarDatos(String s, String s1, String s2) {
            dato.setText(s);
            product.setText(s1);
            cat.setText(s2);
        }
    }
}
