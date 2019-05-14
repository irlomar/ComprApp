package mycompra.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDespensa extends RecyclerView.Adapter<AdapterDespensa.ViewHolderDespensa>  {

    ArrayList<String> listCantidadD;
    ArrayList<String> listProdD;
    ArrayList<String> listCaducidadD;

    public AdapterDespensa(ArrayList<String> listCantidadD, ArrayList<String> listProdD, ArrayList<String> listCaducidadD) {
        this.listCantidadD = listCantidadD;
        this.listProdD = listProdD;
        this.listCaducidadD = listCaducidadD;
    }

    @Override
    public AdapterDespensa.ViewHolderDespensa onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.productos_nevera_list,null,false);
        return new ViewHolderDespensa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDespensa.ViewHolderDespensa viewHolderDespensa, int i) {
        viewHolderDespensa.asignarDatos(listCantidadD.get(i),listProdD.get(i),listCaducidadD.get(i));
    }

    @Override
    public int getItemCount() {
        return listProdD.size();
    }

    public class ViewHolderDespensa extends RecyclerView.ViewHolder {

        TextView cantidadD;
        TextView productD;
        TextView cadD;

        public ViewHolderDespensa(@NonNull View itemView) {
            super(itemView);
            cantidadD = itemView.findViewById(R.id.idCantidadDespensa);
            productD = itemView.findViewById(R.id.idDatoProductoDespensa);
            cadD = itemView.findViewById(R.id.idCaducidadDespensa);
        }

        public void asignarDatos(String s, String s1, String s2) {
            cantidadD.setText(s);
            productD.setText(s1);
            cadD.setText(s2);
        }
    }
}
