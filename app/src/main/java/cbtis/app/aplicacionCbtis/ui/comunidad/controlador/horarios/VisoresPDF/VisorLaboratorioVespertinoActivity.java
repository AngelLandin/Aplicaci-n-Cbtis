package cbtis.app.aplicacionCbtis.ui.comunidad.controlador.horarios.VisoresPDF;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import cbtis.app.aplicacionCbtis.R;

public class VisorLaboratorioVespertinoActivity extends AppCompatActivity {
    public static final long ONE_MEGABYTE = 1024 * 1024*50;

    private String horarioNombre;
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_laboratorio_vespertino);

        this.horarioNombre = getIntent().getStringExtra("TITULO HORARIO");
        this.pdfView = findViewById(R.id.pdfView);

        //Hacemos la conexión al Firebase Storage
        FirebaseStorage mFireBaseStorage = FirebaseStorage.getInstance();
        StorageReference mmFireBaseStorageRef = mFireBaseStorage.getReference().child("Horarios Laboratorio Vespertino");

        mmFireBaseStorageRef.child(horarioNombre).getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                pdfView.fromBytes(bytes).load();
            }
        }).addOnFailureListener(e ->{
            Toast.makeText(VisorLaboratorioVespertinoActivity.this, "Descarga fallida.", Toast.LENGTH_LONG).show();
        });
    }
}