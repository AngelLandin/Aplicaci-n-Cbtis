package cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios;

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
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.VisoresPDF.VisorLaboratorioMatutinoActivity;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.VisoresPDF.VisorMecanicaMatutinoActivity;

public class MecanicaMatutinoActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> horariosMecanicaM;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanica_matutino);

        this.listView = findViewById(R.id.listView_mecanica_matutino);
        this.horariosMecanicaM = new ArrayList<>();

        //Inicializamos el objeto en Firebase
        this.mStorageRef = FirebaseStorage.getInstance().getReference();

        //Llamamos la referencia de bucket donde se almacena los horarios de contabilidad en Firebase Storage
        StorageReference reference = this.mStorageRef.child("Horarios Mecanica Matutino");

        //Codificación para traer todos los titulos de los horarios
        reference.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for(StorageReference item : listResult.getItems()){
                    horariosMecanicaM.add(item.getName() + "");
                }
                //Configuración del adaptador de la lista
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, horariosMecanicaM);

                //Muestro el adaptador en la vista
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        final String tituloHorarioMecanica = listView.getItemAtPosition(position).toString();

                        Intent intent = new Intent(getApplicationContext(), VisorMecanicaMatutinoActivity.class);
                        intent.putExtra("TITULO HORARIO", tituloHorarioMecanica);
                        startActivity(intent);
                    }
                });
            }
        }).addOnFailureListener(e -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MecanicaMatutinoActivity.this);
            builder1.setMessage("Ha ocurrido un error al cargar los cuadernillos. Revisa tu conexión a internet.");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }
            );
            AlertDialog alertDialog = builder1.create();
            alertDialog.show();
        });
    }
}