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

    private List<ListElement> elementos;

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
        elementos.add(new ListElement("Becas Santander Idiomas", "Online English Courses 2023 – British Council 2nd call", "5000 becas para que refuerces tu inglés y mejores tus perspectivas laborales. Estudia desde casa y a tu ritmo y nivel durante 16 semanas. Además obtendrás un certificado de British Council.", "https://app.becas-santander.com/es/program/becas-santander-online-english-courses-2023-2nd-call?category=SKILLS&track=search"));
        elementos.add(new ListElement("Tecnológico de Monterrey", "Lideres del mañana", "Es un programa de movilidad social para formar líderes talentosos y sensibles que impacten positivamente a la comunidad, y que requieren apoyo financiero del 100 % para estudiar una carrera profesional en el Tec de Monterrey.", "https://lideresdelmanana.itesm.mx/"));
        elementos.add(new ListElement("JuventudEsGTO", "Convocatorias Activas.", "Convocatorias de becas por parte del Instituto para el Desarrollo y Atención a las Juventudes del Estado de Guanajuato ", "https://juventudesgto.guanajuato.gob.mx/index.php/convocatorias/"));
        elementos.add(new ListElement("Universidad de Monterrey", "Becas y Ayudas Financieras para Profesional", "¿Eres un alumno destacado, tienes talento, potencial y una trayectoria sobresaliente?\n" +
                "\n" +
                "¡Estudia con nosotros!\n" +
                "En la UDEM contamos con opciones de becas y ayudas financieras para que curses tu carrera.", "https://www.udem.edu.mx/es/admisiones-y-becas/becas-y-apoyos-financieros-profesional"));

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