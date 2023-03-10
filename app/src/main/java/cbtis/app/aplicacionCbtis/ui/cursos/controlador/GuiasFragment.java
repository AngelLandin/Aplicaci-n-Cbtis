package cbtis.app.aplicacionCbtis.ui.cursos.controlador;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.CuadernillosCuartoSActivity;
import cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.VisoresPDF.VisorPDFCuartoActivity;
import cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.VisoresPDF.VisorPDFGuiasEstudio;

public class GuiasFragment extends Fragment {

    private Context context;
    private StorageReference mStorageRef;
    private ListView listViewGuias;
    private ArrayList<String> guiasNombres;

    public GuiasFragment() {
    }

    public static GuiasFragment newInstance(String param1, String param2) {
        GuiasFragment fragment = new GuiasFragment();
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

        this.listViewGuias = view.findViewById(R.id.ListView_guias);
        this.guiasNombres = new ArrayList<>();


        //Inicializando el objecto en FireBase
        this.mStorageRef = FirebaseStorage.getInstance().getReference();

        //Llamo la referencia de bucket donde tengo los cuadernillos guardados en Firebase
        StorageReference reference = this.mStorageRef.child("Guias de estudio");

        //Codificación para traer todos los titulos de los libros
        reference.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>(){
            @Override
            public void onSuccess(ListResult listResult) {
                for (StorageReference item : listResult.getItems()) {
                    guiasNombres.add(item.getName() + "");
                }
                //Configuración del adaptador de la lista
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, guiasNombres);

                //Muestro el adaptador en la vista
                listViewGuias.setAdapter(adapter);

                listViewGuias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        final String titulo_guia_seleccionado = listViewGuias.getItemAtPosition(position).toString();

                        Intent intent = new Intent(getContext(), VisorPDFGuiasEstudio.class);
                        intent.putExtra("TITULO GUIA", titulo_guia_seleccionado);
                        startActivity(intent);
                    }
                });
            }
        }).addOnFailureListener(e -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
            builder1.setMessage("Ha ocurrido un error al cargar los cuadernillos. Revisa tu conexión a internet.");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alert1 = builder1.create();
            alert1.show();
        });
    }
}