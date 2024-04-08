package cbtis.app.aplicacionCbtis.ui.convocatorias;

import android.annotation.SuppressLint;
import android.content.Context;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.convocatorias.adapter.ListAdapter;
import cbtis.app.aplicacionCbtis.ui.convocatorias.adapter.ListElement;

public class ConvocatoriasFragment extends Fragment implements RecyclerViewInterfaceConvocatorias {
    private List<ListElement> listaConvocatorias;
    private RecyclerView recyclerViewConvocatorias;
    private Context mContext;

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

        this.mContext = getContext();
        this.recyclerViewConvocatorias = view.findViewById(R.id.recycler_convocatorias);
        this.listaConvocatorias = new ArrayList<>();

        listaConvocatorias.add(new ListElement("Becas Santander Idiomas", "Online English Courses 2023 – British Council 2nd call", "5000 becas para que refuerces tu inglés y mejores tus perspectivas laborales. Estudia desde casa y a tu ritmo y nivel durante 16 semanas. Además obtendrás un certificado de British Council.", "https://app.becas-santander.com/es/program/becas-santander-online-english-courses-2023-2nd-call?category=SKILLS&track=search"));
        listaConvocatorias.add(new ListElement("Becas Santander", "En Becas Santander nos mueve tu progreso", "Nuestras becas y programas gratuitos están abiertos para todos, no tienes que ser cliente de Banco Santander ni tener título universitario o experiencia profesional.", "https://www.becas-santander.com/es/index.html?status=open&originCountry=MX"));
        listaConvocatorias.add(new ListElement("Tecnológico de Monterrey", "Lideres del mañana", "Es un programa de movilidad social para formar líderes talentosos y sensibles que impacten positivamente a la comunidad, y que requieren apoyo financiero del 100 % para estudiar una carrera profesional en el Tec de Monterrey.", "https://lideresdelmanana.itesm.mx/"));
        listaConvocatorias.add(new ListElement("JuventudEsGTO", "Convocatorias Activas.", "Convocatorias de becas por parte del Instituto para el Desarrollo y Atención a las Juventudes del Estado de Guanajuato ", "https://juventudesgto.guanajuato.gob.mx/index.php/convocatorias/"));
        listaConvocatorias.add(new ListElement("Universidad de Monterrey", "Becas y Ayudas Financieras para Profesional", "¿Eres un alumno destacado, tienes talento, potencial y una trayectoria sobresaliente?\n" +
                "\n" +
                "¡Estudia con nosotros!\n" +
                "En la UDEM contamos con opciones de becas y ayudas financieras para que curses tu carrera.", "https://www.udem.edu.mx/es/admisiones-y-becas/becas-y-apoyos-financieros-profesional"));

        ListAdapter listAdapter = new cbtis.app.aplicacionCbtis.ui.convocatorias.adapter.ListAdapter(listaConvocatorias, mContext, this);
        recyclerViewConvocatorias.setHasFixedSize(true);
        recyclerViewConvocatorias.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewConvocatorias.setAdapter(listAdapter);

    }


    @Override
    public void onItemClick(int position) {
        String urlConvocatoria = this.listaConvocatorias.get(position).getUrlConvocatoria();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlConvocatoria));
        startActivity(intent);
    }
}