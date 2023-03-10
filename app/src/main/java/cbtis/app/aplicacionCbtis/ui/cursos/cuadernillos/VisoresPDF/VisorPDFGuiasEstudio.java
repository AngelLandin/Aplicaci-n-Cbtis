package cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos.VisoresPDF;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import cbtis.app.aplicacionCbtis.R;

public class VisorPDFGuiasEstudio extends AppCompatActivity {
    public static final long ONE_MEGABYTE = 1024 * 1024*50;

    private String nombreGuia;
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_guias_estudio);

        this.pdfView = findViewById(R.id.pdfView_guias_estudio);
        this.nombreGuia = getIntent().getStringExtra("TITULO GUIA");

        //Hacemos la conexión al FireBase Storage
        FirebaseStorage mFireBaseStorage = FirebaseStorage.getInstance();
        StorageReference mmFireBaseStorageRef = mFireBaseStorage.getReference().child("Guias de estudio");

        mmFireBaseStorageRef.child(nombreGuia).getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                pdfView.fromBytes(bytes).load();
            }
        }).addOnFailureListener(e -> {
            Toast.makeText(VisorPDFGuiasEstudio.this, "Descarga fallida", Toast.LENGTH_LONG).show();
        });
    }
}
