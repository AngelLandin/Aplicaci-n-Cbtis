package cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cbtis.app.aplicacionCbtis.R;

public class CuadernillosCuartoSActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> cuadernillosCuartoSemestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadernillos_cuarto_sactivity);

        listView = findViewById(R.id.cuadernillos_cuarto_s);
        this.cuadernillosCuartoSemestre = new ArrayList<>();

        this.cuadernillosCuartoSemestre.add("Primer libro");
        this.cuadernillosCuartoSemestre.add("Segundo Libro");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cuadernillosCuartoSemestre);
        listView.setAdapter(adapter);
    }
}