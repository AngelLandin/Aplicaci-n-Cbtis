package cbtis.app.aplicacionCbtis.ui.convocatorias;

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
import cbtis.app.aplicacionCbtis.adapter.ListAdapter;
import cbtis.app.aplicacionCbtis.adapter.ListElement;

public class ConvocatoriasFragment extends Fragment {

    List<ListElement> elementos;

    public ConvocatoriasFragment() {
    }

    public static ConvocatoriasFragment newInstance(String param1, String param2) {
        ConvocatoriasFragment fragment = new ConvocatoriasFragment();
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
        return inflater.inflate(R.layout.fragment_convocatorias, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        elementos = new ArrayList<>();
        elementos.add(new ListElement("BBVA", "ESTA BECA ES DE PRUEBA XDDDDDDD SI"));
        elementos.add(new ListElement("JUVENTUES", "BECA PARA ESTUDIAR EN LA UG TODO PAGADO SI XD"));

        ListAdapter listAdapter = new ListAdapter(elementos, getContext());
        RecyclerView recyclerView = view.findViewById(R.id.recycler_convocatorias);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }
}