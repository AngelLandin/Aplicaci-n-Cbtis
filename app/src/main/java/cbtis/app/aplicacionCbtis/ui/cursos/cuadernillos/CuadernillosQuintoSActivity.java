package cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cbtis.app.aplicacionCbtis.R;

public class CuadernillosQuintoSActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> cuadernillosQuintoSemestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadernillos_quinto_sactivity);
        listView = findViewById(R.id.cuadernillos_quinto_s);
        this.cuadernillosQuintoSemestre = new ArrayList<>();

        this.cuadernillosQuintoSemestre.add("Primer libro");
        this.cuadernillosQuintoSemestre.add("Segundo libro");
        this.cuadernillosQuintoSemestre.add("Tercer libro");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cuadernillosQuintoSemestre);
        listView.setAdapter(adapter);
    }
}