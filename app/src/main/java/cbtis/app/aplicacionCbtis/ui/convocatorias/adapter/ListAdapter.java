package cbtis.app.aplicacionCbtis.ui.convocatorias.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.convocatorias.RecyclerViewInterfaceConvocatorias;
//Clase encargada de nuestro RecyclerView de Convocatorias

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private final RecyclerViewInterfaceConvocatorias recyclerViewInterfaceConvocatorias;
    private List<ListElement> cardData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context, RecyclerViewInterfaceConvocatorias recyclerViewInterfaceConvocatorias){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.cardData = itemList;
        this.recyclerViewInterfaceConvocatorias = recyclerViewInterfaceConvocatorias;
    }

    @Override
    public int getItemCount() {return this.cardData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.card_convocatoria, null);
        return new ListAdapter.ViewHolder(view, recyclerViewInterfaceConvocatorias);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(cardData.get(position));
    }

    public void setItems(List<ListElement> items) { cardData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView compania, descripcion, tituloConvocatoria;
        CardView urlConvocatoria;

        ViewHolder(View itemView, RecyclerViewInterfaceConvocatorias recyclerViewInterfaceConvocatorias){
            super(itemView);
            compania = itemView.findViewById(R.id.NombreCompaniaTitulo);
            descripcion = itemView.findViewById(R.id.descripcion_convocatoria);
            tituloConvocatoria = itemView.findViewById(R.id.titulo_convocatoria);
            urlConvocatoria = itemView.findViewById(R.id.card_convocatoria);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterfaceConvocatorias != null){
                        int position = getBindingAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterfaceConvocatorias.onItemClick(position);
                        }

                    }
                }
            });

        }

        void bindData(final ListElement item){
            tituloConvocatoria.setText(item.getTituloConvocatoria());
            compania.setText(item.getCompania());
            descripcion.setText(item.getDescripcion());
        }
    }
}
