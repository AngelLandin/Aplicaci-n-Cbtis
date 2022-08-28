package cbtis.app.aplicacionCbtis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BotonesDeRegistro extends AppCompatActivity {

    Button btniniciar_sesión,btnregistrarce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones_de_registro);
        btniniciar_sesión=(Button)findViewById(R.id.btniniciar_sesión);
        btnregistrarce=(Button) findViewById(R.id.btnregistrarce);

        btnregistrarce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent btnregistrarce = new Intent(BotonesDeRegistro.this, Registro.class);
                startActivity(btnregistrarce);
            }
        });

        btniniciar_sesión.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent btniniciar_sesión = new Intent( BotonesDeRegistro.this, IniciarSesión.class);
                startActivity(btniniciar_sesión);
            }
        });

    }
}