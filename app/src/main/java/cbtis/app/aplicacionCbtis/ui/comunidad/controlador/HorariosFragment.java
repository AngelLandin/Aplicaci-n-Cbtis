package cbtis.app.aplicacionCbtis.ui.comunidad.controlador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.ContabilidadMatutinoActivity;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.ContabilidadVespertinoActivity;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.LaboratorioMatutinoActivity;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.LaboratorioVespertinoActivity;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.MecanicaMatutinoActivity;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.MecanicaVespertinoActivity;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.OfimaticaMatutinoActivity;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.OfimaticaVespertinoActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HorariosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HorariosFragment extends Fragment {
    private Button laboratorioMatutino;
    private Button ofimaticaMatutino;
    private Button mecanicaMatutino;
    private Button contabilidadMatutino;
    private Button laboratorioVespertino;
    private Button ofimaticaVespertino;
    private Button mecanicaVespertino;
    private Button contabilidadVespertino;

    private Context mContext;





    public HorariosFragment() {
        // Required empty public constructor
    }
    public static HorariosFragment newInstance(String param1, String param2) {
        HorariosFragment fragment = new HorariosFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_horarios, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mContext = getContext();

        //BOTONES MATUTINOS
        this.contabilidadMatutino = view.findViewById(R.id.button_contabilidad_matutino);
        this.ofimaticaMatutino = view.findViewById(R.id.button_ofimatica_matutino);
        this.mecanicaMatutino = view.findViewById(R.id.button_mecanica_matutino);
        this.laboratorioMatutino = view.findViewById(R.id.button_laboratorio_matutino);

        //BOTONES VESPERTINOS
        this.contabilidadVespertino = view.findViewById(R.id.button_contabilidad_vespertino);
        this.ofimaticaVespertino = view.findViewById(R.id.button_ofimatica_vespertino);
        this.mecanicaVespertino = view.findViewById(R.id.button_mecanica_vespertino);
        this.laboratorioVespertino = view.findViewById(R.id.button_laboratorio_vespertino);

        //LISTENER BOTONES MATUTINOS:
        contabilidadMatutino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ContabilidadMatutinoActivity.class);
                startActivity(intent);
            }
        });

        ofimaticaMatutino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, OfimaticaMatutinoActivity.class);
                startActivity(intent);
            }
        });

        mecanicaMatutino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MecanicaMatutinoActivity.class);
                startActivity(intent);
            }
        });

        laboratorioMatutino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LaboratorioMatutinoActivity.class);
                startActivity(intent);
            }
        });

        //LISTENER BOTONES VESPERTINOS:
        contabilidadVespertino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ContabilidadVespertinoActivity.class);
                startActivity(intent);
            }
        });

        ofimaticaVespertino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, OfimaticaVespertinoActivity.class);
                startActivity(intent);
            }
        });

        mecanicaVespertino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MecanicaVespertinoActivity.class);
                startActivity(intent);
            }
        });

        laboratorioVespertino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LaboratorioVespertinoActivity.class);
                startActivity(intent);
            }
        });


    }
}