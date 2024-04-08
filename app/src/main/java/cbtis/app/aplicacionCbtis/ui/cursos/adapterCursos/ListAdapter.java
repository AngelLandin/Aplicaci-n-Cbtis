package cbtis.app.aplicacionCbtis.ui.cursos.adapterCursos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.controlador.RecyclerViewInterfaceCursos;
//Esta clase sera la encargada de nuestro recyclerView

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final RecyclerViewInterfaceCursos recyclerViewInterfaceCursos;
    private List<ListElementCursos> cardData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElementCursos> itemList, Context context, RecyclerViewInterfaceCursos recyclerViewInterfaceCursos) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.cardData = itemList;
        this.recyclerViewInterfaceCursos = recyclerViewInterfaceCursos;
    }

    @Override
    public int getItemCount() {
        return this.cardData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.mInflater.inflate(R.layout.card_cursos, null);
        return new ListAdapter.ViewHolder(view, recyclerViewInterfaceCursos);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(this.cardData.get(position));
    }

    public void setItems(List<ListElementCursos> items) {
        this.cardData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageCurso;
        TextView tituloCurso, asociacion, descripcionCurso;
        CardView urlCurso;

        ViewHolder(View itemView, RecyclerViewInterfaceCursos recyclerViewInterfaceCursos) {
            super(itemView);
            this.tituloCurso = itemView.findViewById(R.id.titulo_curso);
            this.asociacion = itemView.findViewById(R.id.asociacion_curso);
            this.descripcionCurso = itemView.findViewById(R.id.descripcion_curso);
            this.urlCurso = itemView.findViewById(R.id.cardCurso);
            this.imageCurso = itemView.findViewById(R.id.image_curso);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterfaceCursos != null) {
                        int position = getBindingAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterfaceCursos.onItemClick(position);
                        }

                    }
                }
            });

        }

        void bindData(final ListElementCursos item) {
            this.imageCurso.setImageResource(item.getImage());
            this.tituloCurso.setText(item.getTituloCurso());
            this.asociacion.setText(item.getAsociacion());
            this.descripcionCurso.setText(item.getDescripcion());
        }
    }
}