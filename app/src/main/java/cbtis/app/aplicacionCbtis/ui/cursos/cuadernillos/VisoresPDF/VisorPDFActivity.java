package cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.VisoresPDF;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import cbtis.app.aplicacionCbtis.R;

public class VisorPDFActivity extends AppCompatActivity {
    public static final long ONE_MEGABYTE = 1024 * 1024*50;

    private String cuadernilloNombre;
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_p_d_f);

        this.cuadernilloNombre = getIntent().getStringExtra("TITULO CUADERNILLO");
        this.pdfView = findViewById(R.id.pdfView);

        //Hacemos la conexión al FireBase Storage
        FirebaseStorage mFireBaseStorage = FirebaseStorage.getInstance();
        StorageReference mmFireBaseStorageRef = mFireBaseStorage.getReference().child("Cuadernillos primer s");

        mmFireBaseStorageRef.child(cuadernilloNombre).getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                pdfView.fromBytes(bytes).load();
            }
        }).addOnFailureListener(e -> {
            Toast.makeText(VisorPDFActivity.this, "Descarga fallida", Toast.LENGTH_LONG).show();
        });
    }
}