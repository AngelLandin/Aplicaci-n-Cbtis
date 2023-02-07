package cbtis.app.aplicacionCbtis.ui.cursos.controlador;

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
import android.widget.ArrayAdapter;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterGuias.ListAdapter;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterGuias.RecyclerViewInterfaceGuias;

public class GuiasFragment extends Fragment implements RecyclerViewInterfaceGuias {

    private ListAdapter listAdapter;
    private ArrayList<String> listaElemtosGuias;
    private Context context;
    private StorageReference mStorageRef;

    public GuiasFragment() {
    }

    public static GuiasFragment newInstance(String param1, String param2) {
        GuiasFragment fragment = new GuiasFragment();
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
        return inflater.inflate(R.layout.fragment_guias, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.listaElemtosGuias = new ArrayList<String>();

        //Inicializando el objecto en FireBase
        this.mStorageRef = FirebaseStorage.getInstance().getReference();

        //Llamo la referencia de bucket donde tengo los cuadernillos guardados en Firebase
        StorageReference reference = this.mStorageRef.child("Guias de estudio");

        reference.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>(){
            @Override
            public void onSuccess(ListResult listResult) {
                for (StorageReference item : listResult.getItems()) {
                    listaElemtosGuias.add(item.getName() + "");
                }
            }
        });

        ListAdapter listAdapter = new ListAdapter(this.listaElemtosGuias, getContext(), this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_guias);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
   }

    @Override
    public void onItemClick(int position) {

    }
}