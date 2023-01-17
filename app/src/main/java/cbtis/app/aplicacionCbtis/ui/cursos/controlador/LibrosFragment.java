package cbtis.app.aplicacionCbtis.ui.cursos.controlador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.CuadernillosPrimerSActivity;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterCuadernillos.ListAdapter;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterCuadernillos.ListElementCuadernillos;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterCuadernillos.RecyclerViewInterfaceCuadernillos;
import cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.CuadernillosPrimerSActivity;

public class LibrosFragment extends Fragment implements RecyclerViewInterfaceCuadernillos {
    private ListAdapter listAdapter;
    private List<ListElementCuadernillos> listaElementoCuadernillos;
    private Context context;

    public LibrosFragment() {
        // Required empty public constructor
    }

    public static LibrosFragment newInstance(String param1, String param2) {
        LibrosFragment fragment = new LibrosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_libros, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = getContext();

        this.listaElementoCuadernillos = new ArrayList<>();

        this.listaElementoCuadernillos.add(new ListElementCuadernillos("Cuadernillos 1er. Semestre", R.drawable.primersemestre, "cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.CuadernillosPrimerSActivity"));
        this.listaElementoCuadernillos.add(new ListElementCuadernillos("Cuadernillos 2do. Semestre", R.drawable.segundosemestre, "cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.CuadernillosSegundoSActivity"));
        this.listaElementoCuadernillos.add(new ListElementCuadernillos("Cuadernillos 3er. Semestre", R.drawable.tercersemestre, "cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.CuadernillosTercerSActivity"));
        this.listaElementoCuadernillos.add(new ListElementCuadernillos("Cuadernillos 4to. Semestre", R.drawable.cuartosemestre, "cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.CuadernillosCuartoSActivity"));
        this.listaElementoCuadernillos.add(new ListElementCuadernillos("Cuadernillos 5to. Semestre", R.drawable.quintosemestre, "cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.CuadernillosQuintoSActivity"));
        this.listaElementoCuadernillos.add(new ListElementCuadernillos("Cuadernillos 6to. Semestre", R.drawable.sextosemestre, "cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.CuadernillosSextoSActivity"));

        ListAdapter listAdapter = new ListAdapter(this.listaElementoCuadernillos, getContext(), this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_cuadernillos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
        }

    @Override
    public void onItemClick(int position) {
        Class c = null;
        try {
            c = Class.forName(listaElementoCuadernillos.get(position).getClaseCuadernillos());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(getActivity().getApplicationContext(), c);
        startActivity(intent);

    }
}