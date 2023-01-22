package cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.VisoresPDF.VisorPDFActivity;
import cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.VisoresPDF.VisorPDFSegundoActivity;

public class CuadernillosSegundoSActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> cuadernillosSegundoSemestre;

    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadernillos_segundo_sactivity);

        listView = findViewById(R.id.cuadernillos_segundo_s);
        this.cuadernillosSegundoSemestre = new ArrayList<>();

        //Inicializando el objecto en FireBase
        this.mStorageRef = FirebaseStorage.getInstance().getReference();

        //Llamo la referencia de bucket donde tengo los cuadernillos guardados en Firebase
        StorageReference reference = this.mStorageRef.child("Cuadernillos 2 semestre");

        //Codificación para traer todos los titulos de los libros
        reference.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for (StorageReference item : listResult.getItems()) {
                    cuadernillosSegundoSemestre.add(item.getName() + "");
                }

                //Configuración del adaptador de la lista
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, cuadernillosSegundoSemestre);

                //Muestro el adaptador en la vista
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        final String titulo_cuadernillo_seleccionado = listView.getItemAtPosition(position).toString();

                        Intent intent = new Intent(getApplicationContext(), VisorPDFSegundoActivity.class);
                        intent.putExtra("TITULO CUADERNILLO", titulo_cuadernillo_seleccionado);
                        startActivity(intent);
                    }
                });
            }
        }).addOnFailureListener(e -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(CuadernillosSegundoSActivity.this);
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