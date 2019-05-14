package mycompra.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCongelador extends RecyclerView.Adapter<AdapterCongelador.ViewHolderCongelador> {

    ArrayList<String> listCantidadC;
    ArrayList<String> listProdC;
    ArrayList<String> listCaducidadC;

    public AdapterCongelador(ArrayList<String> listCantidadC, ArrayList<String> listProdC, ArrayList<String> listCaducidadC) {
        this.listCantidadC = listCantidadC;
        this.listProdC = listProdC;
        this.listCaducidadC = listCaducidadC;
    }

    @NonNull
    @Override
    public ViewHolderCongelador onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.productos_nevera_list,null,false);
        return new ViewHolderCongelador(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCongelador viewHolderCongelador, int i) {
        viewHolderCongelador.asignarDatos(listCantidadC.get(i),listProdC.get(i),listCaducidadC.get(i));
    }

    @Override
    public int getItemCount() {
        return listCaducidadC.size();
    }

    public class ViewHolderCongelador extends RecyclerView.ViewHolder {
        TextView cantidadC;
        TextView productC;
        TextView cadC;
        public ViewHolderCongelador(@NonNull View itemView) {
            super(itemView);
            cantidadC = itemView.findViewById(R.id.idCantidadNevera);
            productC = itemView.findViewById(R.id.idDatoProductoNevera);
            cadC = itemView.findViewById(R.id.idCaducidadNevera);
        }

        public void asignarDatos(String s, String s1, String s2) {
            cantidadC.setText(s);
            productC.setText(s1);
            cadC.setText(s2);
        }
    }
}
