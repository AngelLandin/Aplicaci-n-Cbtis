package cbtis.app.aplicacionCbtis.ui.cursos.adapterGuias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterCursos.ListElementCursos;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterGuias.RecyclerViewInterfaceGuias;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterGuias.ListElementGuias;
import cbtis.app.aplicacionCbtis.ui.cursos.controlador.RecyclerViewInterfaceCursos;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final RecyclerViewInterfaceGuias recyclerViewInterfaceGuias;

    private List listaElementos;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(ArrayList<String> itemList, Context context, RecyclerViewInterfaceGuias recyclerViewInterfaceGuias) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.listaElementos = itemList;
        this.recyclerViewInterfaceGuias = recyclerViewInterfaceGuias;
    }

    @Override
    public int getItemCount() {
        return this.listaElementos.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.mInflater.inflate(R.layout.card_cursos, null);
        return new ListAdapter.ViewHolder(view, recyclerViewInterfaceGuias);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData((ListElementGuias) this.listaElementos.get(position));
    }

    public void setItems(List<ListElementGuias> items) { this.listaElementos = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tituloGuia;

        ViewHolder(View itemView, RecyclerViewInterfaceGuias recyclerViewInterfaceGuias){
            super(itemView);

            tituloGuia = itemView.findViewById(R.id.titulo_guia);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterfaceGuias != null){
                        int position = getBindingAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterfaceGuias.onItemClick(position);
                        }
                    }
                }
            });
    }
        void bindData(final ListElementGuias item){
            this.tituloGuia.setText(item.getTituloGuia());
        }
    }
}
