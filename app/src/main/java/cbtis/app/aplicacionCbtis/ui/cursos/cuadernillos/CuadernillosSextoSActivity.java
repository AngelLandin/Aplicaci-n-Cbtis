package cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cbtis.app.aplicacionCbtis.R;

public class CuadernillosSextoSActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> cuadernillosSextoSemestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadernillos_sexto_sactivity);
        listView = findViewById(R.id.cuadernillos_sexto_s);
        this.cuadernillosSextoSemestre = new ArrayList<>();

        this.cuadernillosSextoSemestre.add("Primer libro");
        this.cuadernillosSextoSemestre.add("Segundo libro");
        this.cuadernillosSextoSemestre.add("Tercer libro");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cuadernillosSextoSemestre);
        listView.setAdapter(adapter);
    }
}