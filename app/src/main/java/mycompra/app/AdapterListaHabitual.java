package mycompra.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListaHabitual extends RecyclerView.Adapter<AdapterListaHabitual.ViewHolderListaHabitual>  {

    ArrayList<String> listCategoria;
    ArrayList<CheckBox> listCheckBox;

    public AdapterListaHabitual(ArrayList<String> listCategoria, ArrayList<CheckBox> listCheckBox) {
        this.listCategoria = listCategoria;
        this.listCheckBox = listCheckBox;
    }

    @NonNull
    @Override
    public ViewHolderListaHabitual onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.productos_listahabitual,null,false);

        return new ViewHolderListaHabitual(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListaHabitual viewHolderListaHabitual, int i) {
        viewHolderListaHabitual.asignarDatos(listCategoria.get(i),listCheckBox.get(i));
    }

    @Override
    public int getItemCount() {
        return listCheckBox.size();
    }

    public class ViewHolderListaHabitual extends RecyclerView.ViewHolder {

        TextView catProductos;
        TextView checkBox;

        public ViewHolderListaHabitual(@NonNull View itemView) {
            super(itemView);

            catProductos = itemView.findViewById(R.id.idTextCategoria);
            checkBox = itemView.findViewById(R.id.idCheckBoxProd);
        }

        public void asignarDatos(String s, CheckBox checkBox) {

            catProductos.setText(s);
            checkBox.setText((CharSequence) checkBox);
        }
    }
}
