package cbtis.app.aplicacionCbtis.ui.configuraciones;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import cbtis.app.aplicacionCbtis.BotonesDeRegistro;
import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.configuraciones.adapterAjustes.ListAdapter;
import cbtis.app.aplicacionCbtis.ui.configuraciones.adapterAjustes.ListaElementos;
import cbtis.app.aplicacionCbtis.ui.configuraciones.adapterAjustes.RecyclerViewInterfaceAjustes;

public class ConfiguracionesFragment extends Fragment  implements RecyclerViewInterfaceAjustes {
    private List<ListaElementos> listaElementos;
    private ListAdapter listAdapter;
    private CardView cardView;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    public ConfiguracionesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_configuraciones, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.cardView = view.findViewById(R.id.card_ajustes);
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.user = firebaseAuth.getCurrentUser();

        this.listaElementos = new ArrayList<>();
        listaElementos.add(new ListaElementos(R.drawable.ic_cerrarsesion, "Cerrar Sesión."));
        listaElementos.add(new ListaElementos(R.drawable.ic_pagina_web, "Ir a la página oficial."));
        listaElementos.add(new ListaElementos(R.drawable.ic_facebook, "Ir a la página oficial de facebook."));
        listaElementos.add(new ListaElementos(R.drawable.ic_acercade, "Acerca de."));

        ListAdapter listAdapter = new ListAdapter(this.listaElementos, getContext(), this);
        RecyclerView recyclerView =view.findViewById(R.id.recycler_ajustes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);


    }

    @Override
    public void onItemClick(int position) {
        if(position == 0){
            cerrarSesion();
        }


        if(position == 1){
            String urlPaginaOficial = "https://www.cbtis238.edu.mx/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPaginaOficial));
            startActivity(intent);
        }

        if(position == 2){
            String urlPaginaOficial = "https://web.facebook.com/somoscbtis238";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPaginaOficial));
            startActivity(intent);
        }

        if(position == 3){
            Intent intent = new Intent(getContext(), AcercaDe.class);
            startActivity(intent);
        }
    }

    private void cerrarSesion(){
        this.firebaseAuth.signOut();
        startActivity(new Intent(getContext(), BotonesDeRegistro.class));
        Toast.makeText(getContext(), "Sesión Cerrada", Toast.LENGTH_LONG).show();
        getActivity().finish();
    }
}