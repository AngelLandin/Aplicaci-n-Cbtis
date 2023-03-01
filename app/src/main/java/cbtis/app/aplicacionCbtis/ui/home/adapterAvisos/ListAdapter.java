package cbtis.app.aplicacionCbtis.ui.home.adapterAvisos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cbtis.app.aplicacionCbtis.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private final RecyclerViewInterfaceAvisos recyclerViewInterfaceAvisos;
    private List<ListaElementos> listaElementosAvisos;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListaElementos> itemList, Context context, RecyclerViewInterfaceAvisos recyclerViewInterfaceAvisos){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.listaElementosAvisos = itemList;
        this.recyclerViewInterfaceAvisos = recyclerViewInterfaceAvisos;
    }

    @Override
    public int getItemCount() {return this.listaElementosAvisos.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_avisos, null);
        return new ListAdapter.ViewHolder(view, recyclerViewInterfaceAvisos);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(listaElementosAvisos.get(position));

    }

    public void setItems(List<ListaElementos> items) { this.listaElementosAvisos = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView descripcionAviso, fechaAviso, urlAvisos;
        private ImageView imageAviso;

        ViewHolder(View viewItem, RecyclerViewInterfaceAvisos recyclerViewInterfaceAvisos){
            super(viewItem);
            descripcionAviso = viewItem.findViewById(R.id.descripcion_aviso);
            imageAviso = viewItem.findViewById(R.id.image_avisos);
            fechaAviso = viewItem.findViewById(R.id.fecha_aviso);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterfaceAvisos != null){
                        int position = getBindingAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterfaceAvisos.onItemClick(position);
                        }
                    }
                }
            });
        }

        void bindData(final ListaElementos item){
            descripcionAviso.setText(item.getDescripcion());
            fechaAviso.setText(item.getFecha());

            //ImageView: Glide library
            Glide.with(context)
                    .load(item.getImage())
                    .into(imageAviso);
        }
    }
}
