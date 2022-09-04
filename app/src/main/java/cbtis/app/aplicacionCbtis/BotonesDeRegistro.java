package cbtis.app.aplicacionCbtis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cbtis.app.aplicacionCbtis.databinding.ActivityBotonesDeRegistroBinding;

public class BotonesDeRegistro extends AppCompatActivity {
    private ActivityBotonesDeRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBotonesDeRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent btnRegistrarse = new Intent(BotonesDeRegistro.this, Registro.class);
        Intent bttIniciarSesión = new Intent( BotonesDeRegistro.this, IniciarSesión.class);

        binding.btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(btnRegistrarse);
            }
        });

        binding.btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(bttIniciarSesión);
            }
        });

    }
}