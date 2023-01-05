package cbtis.app.aplicacionCbtis.ui.cursos.controlador;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterCursos.ListAdapter;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterCursos.ListElementCursos;

public class CursosFragment extends Fragment implements RecyclerViewInterfaceCursos{
    private ListAdapter listAdapter;
    private List<ListElementCursos> listaElemento;

    public CursosFragment() {
        // Required empty public constructor
    }

    public static CursosFragment newInstance(String param1, String param2) {
        CursosFragment fragment = new CursosFragment();
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
        return inflater.inflate(R.layout.fragment_cursos2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaElemento = new ArrayList<>();
        listaElemento.add(new ListElementCursos(R.drawable.cursoderivadas, "Bases Matemáticas: Derivadas", "EDX Course", "Curso básico sobre funciones y sus derivadas, incluyendo sus aplicaciones a la resolución de problemas.", "https://www.edx.org/course/bases-matematicas-derivadas?index=product_value_experiment_a&queryID=b870d44622b23b65e47f618d2f1c90e1&position=4"));
        listaElemento.add(new ListElementCursos(R.drawable.algebra, "Álgebra 1", "Khan Academy", "Curso de álgebra que abarca los temas de ecuaciones lineales, desigualdades, funciones y gráficas", "https://es.khanacademy.org/math/algebra"));
        listaElemento.add(new ListElementCursos(R.drawable.algebra2, "Álgebra 2", "Khan Academy", "Curso de álgebra 2 que cubre polinomios, números complejos, exponentes racionales, funciones exponenciales y logarítmicas", "https://es.khanacademy.org/math/algebra2"));



        ListAdapter listAdapter = new ListAdapter(listaElemento, getContext(), this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_cursos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);

    }

    @Override
    public void onItemClick(int position) {
        String urlCurso = listaElemento.get(position).getUrlCurso();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlCurso));
        startActivity(intent);
    }
}