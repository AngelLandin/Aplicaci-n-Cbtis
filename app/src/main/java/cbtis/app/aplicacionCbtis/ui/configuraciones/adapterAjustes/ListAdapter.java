package cbtis.app.aplicacionCbtis.ui.configuraciones.adapterAjustes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cbtis.app.aplicacionCbtis.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private final RecyclerViewInterfaceAjustes recyclerViewInterfaceAjustes;
    private List<ListaElementos> datosCard;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListaElementos> itemList, Context context, RecyclerViewInterfaceAjustes recyclerViewInterfaceAjustes){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.datosCard = itemList;
        this.recyclerViewInterfaceAjustes = recyclerViewInterfaceAjustes;
    }

    @Override
    public int getItemCount() {return this.datosCard.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.card_ajustes, null);
        return new ListAdapter.ViewHolder(view, recyclerViewInterfaceAjustes);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(datosCard.get(position));
    }

    public void setItems(List<ListaElementos> items) { this.datosCard = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView seccion;
        ImageView image;

        ViewHolder(View viewItem, RecyclerViewInterfaceAjustes recyclerViewInterfaceAjustes){
            super(viewItem);
            seccion = viewItem.findViewById(R.id.text_ajustes);
            image = viewItem.findViewById(R.id.image_ajustes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterfaceAjustes != null){
                        int position = getBindingAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterfaceAjustes.onItemClick(position);
                        }
                    }
                }
            });
        }

        void bindData(final ListaElementos item){
            seccion.setText(item.getSeccion());
            image.setImageResource(item.getImage());
        }
    }
}
