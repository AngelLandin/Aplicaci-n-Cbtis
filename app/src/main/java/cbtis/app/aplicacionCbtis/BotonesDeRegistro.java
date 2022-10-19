package cbtis.app.aplicacionCbtis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cbtis.app.aplicacionCbtis.databinding.ActivityBotonesDeRegistroBinding;

public class BotonesDeRegistro extends AppCompatActivity {
    private ActivityBotonesDeRegistroBinding binding;
    private Button btnIniciarSesion;
    private Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBotonesDeRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btnIniciarSesion = binding.btnIniciarSesion;
        btnRegistrarse = binding.btnregistrarse;

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion(view);
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarse(view);
            }
        });
    }

    public void iniciarSesion(View view){
        Intent inicioSesion = new Intent(getApplicationContext(), IniciarSesión.class);
        startActivity(inicioSesion);
    }

    public void registrarse(View view){
        Intent registro = new Intent(getApplicationContext(), Registro.class);
        startActivity(registro);
    }
}