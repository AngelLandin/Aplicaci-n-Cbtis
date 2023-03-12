package cbtis.app.aplicacionCbtis.ui.comunidad.controlador;

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
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.adapterClubs.ListAdapterClubs;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.adapterClubs.ListaElementosClubs;


public class ClubsFragment extends Fragment {
    private List<ListaElementosClubs> elementosClubsList;

    public ClubsFragment() {
        // Required empty public constructor
    }

    public static ClubsFragment newInstance(String param1, String param2) {
        ClubsFragment fragment = new ClubsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clubs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.elementosClubsList = new ArrayList<>();

        //Agregamos los clubs al RecyclerView
        //Clubs deportivos.
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.futbol, "Club de Futbol", "Juego entre dos equipos de once jugadores cada uno, cuyo objetivo es hacer entrar en la portería contraria un balón que no puede ser tocado con las manos ni con los brazos."));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.basquet, "Club de Basquetbol", "El baloncesto o básquetbol es un deporte en el cual compiten dos equipos de cinco jugadores cada uno. El objetivo es introducir la pelota (balón) en el aro (cesta o canasta) del equipo contrario."));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.voleibol, "Club de Voleibol", "El voleibol, es un deporte donde dos equipos se enfrentan sobre un terreno de juego liso separados por una red central, tratando de pasar el balón por encima de la red hacia el suelo del campo contrario."));

        //Clubs culturales.
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.danza, "Club de danza", "La danza es un movimiento puesto en forma rítmica y espacial, una sucesión de movimientos que comienza, se desarrolla y finaliza."));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.dibujo, "Club de dibujo", "El Club De Dibujo fue creado para todas las personas que están interesadas en dibujar, ya sea como hobby o como parte de su profesión."));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.ciencias, "Club de Ciencias", "Lo forman un grupo de jóvenes con una organización establecida que, orientados por un adulto, desarrollan actividades que favorecen la educación científica y tecnología del grupo y de la comunidad, contribuyendo a una mejor comprensión de la función de la ciencia y la tecnología en el momento actual."));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.rondalla, "Club de rondalla", "La rondalla es un conjunto musical conformado por instrumentos de cuerda que se tocan generalmente con el plectro. El Club de Rondalla le ofrece cantar y divertirse y tocar un instrumento musical."));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.ecologia, "Club de ecologia", "Los jovenes que integran este club se encargan de elaborar y desarrollar labores de promoción relacionadas con la cultura ecológica"));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.teatro, "Club de teatro", "El club de teatro tiene el propósito de generar un espacio de convivencia para la formación teatral, la comunicación a través del teatro, el intercambio entre teatristas y público."));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.ajedrez, "Club de ajedrez", "El club de ajedrez es un club formado con el propósito de jugar el juego de mesa del ajedrez."));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.robotica, "Club de robotica", "El Club de Robótica es un espacio de experimentación, en el que se aplican estrategias tanto de aprendizaje activo como construccionista."));
        this.elementosClubsList.add(new ListaElementosClubs(R.drawable.banda_guerra, "Club de banda de guerra", "Es una disciplina que se practica por medio de cornetas y clarines, se hace acompañar con caseros, la cual está constituida por 12 caseros, 12 cornetas, una corneta y un comandante."));

        ListAdapterClubs listAdapterClubs = new ListAdapterClubs(elementosClubsList, getContext());
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerView_Clubs);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapterClubs);
    }
}