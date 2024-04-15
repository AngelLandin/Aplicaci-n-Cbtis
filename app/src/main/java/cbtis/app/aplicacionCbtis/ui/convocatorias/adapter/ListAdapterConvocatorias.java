package cbtis.app.aplicacionCbtis.ui.convocatorias.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.controlador.RecyclerViewInterfaceCursos;

public class ListAdapterConvocatorias extends RecyclerView.Adapter<ListAdapterConvocatorias.ViewHolder> {

    private RecyclerViewInterfaceConvocatorias recyclerViewInterfaceConvocatorias;
    private Context mContext;
    private List<Convocatorias> convocatoriasLista;
    private LayoutInflater mInflater;
    public ListAdapterConvocatorias(ArrayList<Convocatorias> convocatoriasLista, Context context, RecyclerViewInterfaceConvocatorias recyclerViewInterfaceConvocatorias) {
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.convocatoriasLista = convocatoriasLista;
        this.recyclerViewInterfaceConvocatorias = recyclerViewInterfaceConvocatorias;
    }


    @Override
    public ListAdapterConvocatorias.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_convocatoria, null);
        return new ListAdapterConvocatorias.ViewHolder(view, recyclerViewInterfaceConvocatorias);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(convocatoriasLista.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getBindingAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    recyclerViewInterfaceConvocatorias.onItemClick(position);
                }

            }
        });

    }

    public void setItems(List<Convocatorias> items){this.convocatoriasLista = items;}

    @Override
    public int getItemCount() {
        return convocatoriasLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Widgets
        TextView textViewTitulo;
        CardView textViewurlConvocatoria;
        TextView textViewAsociacion;
        TextView textViewDescripcion;

        public ViewHolder(View itemView, RecyclerViewInterfaceConvocatorias recyclerViewInterfaceConvocatorias){
            super(itemView);
            this.textViewTitulo = itemView.findViewById(R.id.titulo_convocatoria);
            this.textViewAsociacion = itemView.findViewById(R.id.NombreCompaniaTitulo);
            this.textViewDescripcion = itemView.findViewById(R.id.descripcion_convocatoria);
            this.textViewurlConvocatoria = itemView.findViewById(R.id.card_convocatoria_link);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getBindingAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        recyclerViewInterfaceConvocatorias.onItemClick(position);
                    }
                }
            });

        }
        void bindData(final Convocatorias item){
            textViewTitulo.setText(item.getTituloConvocatoria());
            textViewAsociacion.setText(item.getAsociacionConvocatoria());
            textViewDescripcion.setText(item.getDescripcionConvocatoria());

            //ImageView : Glide Library

            /*Glide.with(mContext)
                    .load(item.getImageUrl())
                    .into(imageViewCurso);

             */
        }
    }
}

