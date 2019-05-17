package mycompra.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListas extends RecyclerView.Adapter<AdapterListas.ViewHolderListas> implements View.OnClickListener{

    ArrayList<String> nombreListas;
    private View.OnClickListener listener;

    public AdapterListas(ArrayList<String> nombreListas) {
        this.nombreListas = nombreListas;
    }

    @NonNull
    @Override
    public ViewHolderListas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_listas,null,false);
        view.setOnClickListener(this);
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

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){listener.onClick(v);}
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
