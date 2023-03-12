package cbtis.app.aplicacionCbtis.ui.comunidad.controlador.adapterClubs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;


public class ListAdapterClubs extends RecyclerView.Adapter<ListAdapterClubs.ViewHolder> {
    private List<ListaElementosClubs> listaElementosClubs;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapterClubs(List<ListaElementosClubs> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.listaElementosClubs = itemList;
    }

    @Override
    public int getItemCount(){return this.listaElementosClubs.size();}

    @Override
    public ListAdapterClubs.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.card_clubs, null);
        return new ListAdapterClubs.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterClubs.ViewHolder holder, final int position){
        holder.bindData(listaElementosClubs.get(position));
    }

    public void setItems(List<ListaElementosClubs> items){listaElementosClubs = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView club, descripcionClub;
        ImageView imageClub;

        ViewHolder(View viewItem){
            super(viewItem);
            club = viewItem.findViewById(R.id.titulo_Club);
            descripcionClub = viewItem.findViewById(R.id.descrpcion_club);
            imageClub = viewItem.findViewById(R.id.image_club);
        }

        public void bindData(final ListaElementosClubs item){
            this.imageClub.setImageResource(item.getImageClub());
            this.club.setText(item.getClub());
            this.descripcionClub.setText(item.getDescripcionClub());
        }
    }
}
