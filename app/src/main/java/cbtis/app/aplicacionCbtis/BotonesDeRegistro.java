package cbtis.app.aplicacionCbtis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BotonesDeRegistro extends AppCompatActivity {

    private Button btniniciar_sesión;
    private Button btnregistrarse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones_de_registro);
        btniniciar_sesión = (Button)findViewById(R.id.btniniciar_sesión);
        btnregistrarse = (Button) findViewById(R.id.btnregistrarce);
        Intent btnRegistrarse = new Intent(this, Registro.class);
        Intent bttIniciarSesión = new Intent( BotonesDeRegistro.this, IniciarSesión.class);



        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(btnRegistrarse);
            }
        });

        btniniciar_sesión.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(bttIniciarSesión);
            }
        });

    }
}