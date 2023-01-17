package cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cbtis.app.aplicacionCbtis.R;

public class CuadernillosSegundoSActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> cuadernillosSegundoSemestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadernillos_segundo_sactivity);

        listView = findViewById(R.id.cuadernillos_segundo_s);
        this.cuadernillosSegundoSemestre = new ArrayList<>();

        this.cuadernillosSegundoSemestre.add("Primer libro");
        this.cuadernillosSegundoSemestre.add("Segundo libro");
        this.cuadernillosSegundoSemestre.add("Tercer libro");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cuadernillosSegundoSemestre);
        listView.setAdapter(adapter);
    }
}