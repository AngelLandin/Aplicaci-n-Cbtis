package cbtis.app.aplicacionCbtis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;
//Esta clase sera la encargada de nuestro recyclerView

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<ListElement> cardData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.cardData = itemList;
    }

    @Override
    public int getItemCount() {return this.cardData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.card_convocatoria, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(cardData.get(position));
    }

    public void setItems(List<ListElement> items) { cardData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView compania, descripcion;
        Button boton;

        ViewHolder(View itemView){
            super(itemView);
            compania = itemView.findViewById(R.id.name_compania);
            descripcion = itemView.findViewById(R.id.descripcion_beca);
            boton = itemView.findViewById(R.id.boton_ir);
        }

        void bindData(final ListElement item){
            compania.setText(item.getCompania());
            descripcion.setText(item.getDescripcion());
        }
    }
}
