package cbtis.app.aplicacionCbtis.ui.convocatorias;

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

import cbtis.app.aplicacionCbtis.ui.convocatorias.adapter.ListAdapter;
import cbtis.app.aplicacionCbtis.ui.convocatorias.adapter.ListElement;

public class ConvocatoriasFragment extends Fragment implements RecyclerViewInterfaceConvocatorias {

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
        elementos.add(new ListElement("SANTANDER", "Santander Scholarships Language | UK English Summer Experience 2023", "Si quieres pasar tres semanas en un campus universitario británico este verano, Banco Santander, en colaboración con British Council, ofrece 100 becas", "https://app.becas-santander.com/es/program/santander-scholarships-language-uk-english-summer-experience-2023"));
        elementos.add(new ListElement("Tecnológico de Monterrey", "Lideres del mañana", "Es un programa de movilidad social para formar líderes talentosos y sensibles que impacten positivamente a la comunidad, y que requieren apoyo financiero del 100 % para estudiar una carrera profesional en el Tec de Monterrey.", "https://lideresdelmanana.itesm.mx/"));
        elementos.add(new ListElement("Santander", "Becas Santander Estudios | Fundación Fibra Educa (FEDUCA) 2023", "El Programa “Becas Santander – Estudios – Fundación Fibra Educa (FEDUCA) 2023” (en lo sucesivo “el Programa”) es una iniciativa de Fundación Fibra Educa", "https://app.becas-santander.com/es/program/becas-santander-estudios-fundacion-fibra-educa-feduca-2023?category=STUDIESstatus%3DopenoriginCountry%3DMX&track=search"));

        ListAdapter listAdapter = new ListAdapter(elementos, getContext(), this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_convocatorias);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void onItemClick(int position) {
        String urlConvocatoria = elementos.get(position).getUrlConvocatoria();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlConvocatoria));
        startActivity(intent);
    }
}