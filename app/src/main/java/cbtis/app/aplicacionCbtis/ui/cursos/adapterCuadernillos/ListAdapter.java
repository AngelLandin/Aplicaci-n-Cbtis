package cbtis.app.aplicacionCbtis.ui.cursos.adapterCuadernillos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterCursos.ListElementCursos;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final RecyclerViewInterfaceCuadernillos recyclerViewInterfaceCuadernillos;
    private List<ListElementCuadernillos> elementCuadernillos;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElementCuadernillos> itemList, Context context, RecyclerViewInterfaceCuadernillos recyclerViewInterfaceCuadernillos){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.elementCuadernillos = itemList;
        this.recyclerViewInterfaceCuadernillos = recyclerViewInterfaceCuadernillos;
    }

    @Override
    public int getItemCount() {return this.elementCuadernillos.size();}

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.mInflater.inflate(R.layout.card_cuadernillos, null);
        return new ListAdapter.ViewHolder(view, recyclerViewInterfaceCuadernillos);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(this.elementCuadernillos.get(position));
    }

    public void setItems(List<ListElementCuadernillos> items) { this.elementCuadernillos = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageSemestre;
        TextView textSemestre;
        CardView cardViewCuadernillos;

        ViewHolder(View itemView, RecyclerViewInterfaceCuadernillos recyclerViewInterfaceCuadernillos){
            super(itemView);
            this.imageSemestre = itemView.findViewById(R.id.image_cuadernillos);
            this.textSemestre = itemView.findViewById(R.id.text_semestre_cuadernillos);
            this.cardViewCuadernillos = itemView.findViewById(R.id.cardView_cuadernillos);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterfaceCuadernillos != null){
                        int position = getBindingAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterfaceCuadernillos.onItemClick(position);
                        }

                    }
                }
            });
        }

        void bindData(final ListElementCuadernillos item){
            this.imageSemestre.setImageResource(item.getImageCuadernillos());
            this.textSemestre.setText(item.getSemestreCuadernillos());
        }
    }
}
