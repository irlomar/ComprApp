package mycompra.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListas extends RecyclerView.Adapter<AdapterListas.ViewHolderListas> {

    ArrayList<String> nombreListas;

    public AdapterListas(ArrayList<String> nombreListas) {
        this.nombreListas = nombreListas;
    }

    @NonNull
    @Override
    public ViewHolderListas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_listas,null,false);
        return new ViewHolderListas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListas viewHolderListas, int i) {
        viewHolderListas.asignarDatos(nombreListas.get(i));
    }

    @Override
    public int getItemCount() {
        return nombreListas.size();
    }


    public class ViewHolderListas extends RecyclerView.ViewHolder {

        TextView nombre;

        public ViewHolderListas(@NonNull View itemView) {
            super(itemView);
            nombre =itemView.findViewById(R.id.idNombreListas);
        }

        public void asignarDatos(String s) {

            nombre.setText(s);
        }
    }
}
