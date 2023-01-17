package cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import cbtis.app.aplicacionCbtis.R;

public class CuadernillosPrimerSActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> cuadernillosPrimerSemestre;

    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadernillos_primer_sactivity);
        listView = findViewById(R.id.cuadernillos_primer_s);
        cuadernillosPrimerSemestre = new ArrayList<>();

        //Inicializando el objecto en FireBase
        this.storageReference = FirebaseStorage.getInstance().getReference();

        //Llamo la referencia de bucket donde tengo los cuadernillos guardados en Firebase
        StorageReference reference = this.storageReference.child("Cuadernillos 1° Semestre");

        //Codificación para traer todos los titulos de los libros
        reference.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for(StorageReference item: listResult.getItems()){
                    cuadernillosPrimerSemestre.add(item.getName()+"");
                }

                //Configuración del adaptador de la lista
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, cuadernillosPrimerSemestre);

                //Muestro el adaptador en la vista
                listView.setAdapter(adapter);

            }
        });
    }
}