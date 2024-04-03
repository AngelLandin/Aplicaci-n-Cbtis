package cbtis.app.aplicacionCbtis.ui.comunidad.controlador.adapterClubs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cbtis.app.aplicacionCbtis.R;


public class ListAdapterClubs extends RecyclerView.Adapter<ListAdapterClubs.ViewHolder> {
    private final RecyclerViewInterfaceClubs recyclerViewInterfaceClubs;
    private List<ListaElementosClubs> listaElementosClubs;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapterClubs(List<ListaElementosClubs> itemList, Context context, RecyclerViewInterfaceClubs recyclerViewInterfaceClubs){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.listaElementosClubs = itemList;
        this.recyclerViewInterfaceClubs = recyclerViewInterfaceClubs;
    }

    @Override
    public int getItemCount(){return this.listaElementosClubs.size();}

    @Override
    public ListAdapterClubs.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.card_clubs, null);
        return new ListAdapterClubs.ViewHolder(view, recyclerViewInterfaceClubs);
    }

    @Override
    public void onBindViewHolder(final ListAdapterClubs.ViewHolder holder, final int position){
        holder.bindData(listaElementosClubs.get(position));
    }

    public void setItems(List<ListaElementosClubs> items){listaElementosClubs = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView club, descripcionClub;
        private ImageView imageClub;

        ViewHolder(View viewItem, RecyclerViewInterfaceClubs recyclerViewInterfaceClubs){
            super(viewItem);
            club = viewItem.findViewById(R.id.titulo_Club);
            descripcionClub = viewItem.findViewById(R.id.descrpcion_club);
            imageClub = viewItem.findViewById(R.id.image_club);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterfaceClubs != null){
                        int position = getBindingAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterfaceClubs.onItemClick(position);
                        }
                    }
                }
            });
        }

        public void bindData(final ListaElementosClubs item){
            this.club.setText(item.getClub());
            this.descripcionClub.setText(item.getDescripcionClub());

            //ImageView: Glide Library, para obtener la imagen desde la base de datos
            Glide.with(context)
                    .load(item.getImageClub())
                    .into(imageClub);
        }
    }
}
