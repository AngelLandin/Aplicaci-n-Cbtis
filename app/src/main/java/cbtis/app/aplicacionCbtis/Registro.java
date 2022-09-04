package cbtis.app.aplicacionCbtis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cbtis.app.aplicacionCbtis.databinding.ActivityIniciarSesionBinding;
import cbtis.app.aplicacionCbtis.databinding.ActivityInterfazRegistroBinding;

public class Registro extends AppCompatActivity {

    private ActivityInterfazRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInterfazRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = new Intent(Registro.this, BarraNavegacion.class);

        binding.btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });
    }
}