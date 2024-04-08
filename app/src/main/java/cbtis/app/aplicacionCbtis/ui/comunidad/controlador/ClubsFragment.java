package cbtis.app.aplicacionCbtis.ui.comunidad.controlador;

import android.annotation.SuppressLint;
import android.content.Context;
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
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.adapterClubs.ListAdapterClubs;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.adapterClubs.ListaElementosClubs;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.adapterClubs.RecyclerViewInterfaceClubs;


public class ClubsFragment extends Fragment implements RecyclerViewInterfaceClubs {
    //FireBase Database
    private DatabaseReference databaseReference;

    //Variables
    private RecyclerViewInterfaceClubs recyclerViewInterfaceClubs;
    private ListAdapterClubs listAdapterClubs;
    private ArrayList<ListaElementosClubs> elementosClubsList;
    private Context mContext;
    private RecyclerView recyclerViewClubs;

    public ClubsFragment() {
        // Constructor vacio de la clase, requerido
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
        View root = inflater.inflate(R.layout.fragment_clubs, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Agregamos los valores a los atributos de clase.
        this.mContext = getContext();
        this.recyclerViewClubs = view.findViewById(R.id.recyclerView_Clubs);
        this.elementosClubsList = new ArrayList<>();

        //Obtenemos la referencia de la base de datos
        this.databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://app-cb-ba8d4-default-rtdb.firebaseio.com/").child("Club");

        //Llamamos la función para obtener los datos de Firebase
        obtenerDatosDesdeFirebase();

        ListAdapterClubs listAdapter = new ListAdapterClubs(elementosClubsList, mContext, recyclerViewInterfaceClubs);
        this.recyclerViewClubs.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        this.recyclerViewClubs.setLayoutManager(linearLayoutManager);
        recyclerViewClubs.setAdapter(listAdapter);
    }

    private void obtenerDatosDesdeFirebase() {
        Query query = databaseReference;
        query.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                limpiarTodo();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    ListaElementosClubs listaElementos = new ListaElementosClubs();

                    listaElementos.setImageClub(snapshot.child("imagen").getValue().toString()); //Obteniendo la imagen desde FireBase
                    listaElementos.setDescripcionClub(snapshot.child("descripcion").getValue().toString());
                    listaElementos.setClub(snapshot.child("club").getValue().toString());

                    elementosClubsList.add(listaElementos);
                }
                listAdapterClubs = new ListAdapterClubs(elementosClubsList, mContext, recyclerViewInterfaceClubs);
                recyclerViewClubs.setAdapter(listAdapterClubs);
                listAdapterClubs.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void limpiarTodo(){
        if(elementosClubsList != null){
            elementosClubsList.clear();

            if(listAdapterClubs != null){
                listAdapterClubs.notifyDataSetChanged();
            }
        }
        elementosClubsList = new ArrayList<>();
    }

    @Override
    public void onItemClick(int position) {

    }
}