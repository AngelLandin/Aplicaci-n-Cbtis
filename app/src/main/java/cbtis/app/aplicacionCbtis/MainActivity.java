package cbtis.app.aplicacionCbtis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botonEntrar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonEntrar = (Button) findViewById(R.id.btnEntrar);
        Intent actividad2 = new Intent(this, InterfazRegistro.class);

        botonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(actividad2);
                finish();
            }
        });
    }
}