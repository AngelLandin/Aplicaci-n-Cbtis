package cbtis.app.aplicacionCbtis.ui.home;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.messaging.FirebaseMessaging;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.home.adapterAvisos.ListAdapter;
import cbtis.app.aplicacionCbtis.ui.home.adapterAvisos.ListaElementos;
import cbtis.app.aplicacionCbtis.ui.home.adapterAvisos.RecyclerViewInterfaceAvisos;

public class HogarFragment extends Fragment implements RecyclerViewInterfaceAvisos {
    //Firebase Database:
    private DatabaseReference databaseReference;

    //Variables
    private RecyclerViewInterfaceAvisos recyclerViewInterfaceAvisos;
    private ArrayList<ListaElementos> listaElementosAvisos;
    private RecyclerView recyclerViewAvisos;
    private ListAdapter listAdapterAvisos;
    private Context mContext;

    public HogarFragment() {
        //Este es un Constructor vacio de la clase, requerido
    }

    public static HogarFragment newInstance(String param1, String param2) {
        HogarFragment fragment = new HogarFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hogar, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mContext = getContext();
        this.recyclerViewAvisos = view.findViewById(R.id.recycler_avisos);
        this.listaElementosAvisos = new ArrayList<>();

        this.databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://app-cb-ba8d4-default-rtdb.firebaseio.com/").child("Avisos");

        obtenerDatosDesdeFirebase();

        ListAdapter listAdapter = new ListAdapter((List<ListaElementos>) listaElementosAvisos, mContext, this);
        this.recyclerViewAvisos.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        this.recyclerViewAvisos.setLayoutManager(linearLayoutManager);
        recyclerViewAvisos.setAdapter(listAdapter);
    }

    @Override
    public void onItemClick(int position) {
    }

    private void obtenerDatosDesdeFirebase(){ //Funcion para obtener los datos de la base de datos de FireBase
        Query query = databaseReference;
        query.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                limpiarTodo();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    ListaElementos listaElementos = new ListaElementos();

                    listaElementos.setImage(snapshot.child("image").getValue().toString());//Obteniendo los datos del campo "image" de la BD.
                    listaElementos.setDescripcion(snapshot.child("descripcion").getValue().toString());//Obteniendo los datos del campo "descripcion" de la bd
                    listaElementos.setUrlAviso(snapshot.child("urlaviso").getValue().toString());//Obteniendo los datos del campo "urlaviso" de la bd. Nota:Este no lo usamos
                    listaElementos.setFecha(snapshot.child("fecha").getValue().toString());//Obteniendo los datos del campo "fecha" de la bd.

                    listaElementosAvisos.add(listaElementos);
                }
                listAdapterAvisos = new ListAdapter((List<ListaElementos>) listaElementosAvisos, mContext, recyclerViewInterfaceAvisos);
                recyclerViewAvisos.setAdapter(listAdapterAvisos);
                listAdapterAvisos.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void limpiarTodo(){
        if(listaElementosAvisos != null){
            listaElementosAvisos.clear();

            if(listAdapterAvisos != null){
                listAdapterAvisos.notifyDataSetChanged();
            }
        }
        listaElementosAvisos = new ArrayList<>();
    }
}