package cbtis.app.aplicacionCbtis.ui.cursos.cuadernillos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cbtis.app.aplicacionCbtis.R;

public class CuadernillosTercerSActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> cuadernillosTercerSemestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadernillos_tercer_sactivity);

        listView = findViewById(R.id.cuadernillos_tercer_s);
        this.cuadernillosTercerSemestre = new ArrayList<>();

        this.cuadernillosTercerSemestre.add("Primer libro");
        this.cuadernillosTercerSemestre.add("Segundo libro");
        this.cuadernillosTercerSemestre.add("Tercer libro");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cuadernillosTercerSemestre);
        listView.setAdapter(adapter);
    }
}