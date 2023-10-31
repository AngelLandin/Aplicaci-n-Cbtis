package cbtis.app.aplicacionCbtis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cbtis.app.aplicacionCbtis.databinding.ActivityBotonesDeRegistroBinding;

public class BotonesDeRegistro extends AppCompatActivity {
    private ActivityBotonesDeRegistroBinding binding;
    private FirebaseAuth firebaseAuth; //Instancia de Firebase para la autenticacion de Usuario
    private Button btnIniciarSesion; //Boton Iniciar Sesion
    private Button btnRegistrarse; //Boton Registrarse

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBotonesDeRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicialize();
        this.btnIniciarSesion = binding.btnIniciarSesion; //Llamamos a nuestro boton Iniciar Sesion
        this.btnRegistrarse = binding.btnregistrarse; //Llamamos a nuestro Boton Registrar

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            //Agregamos un oyente a nuestro boton para detectar los clicks.
            @Override
            public void onClick(View view) {
                iniciarSesion(view);
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            //Agregamos un oyente a nuestro boton para detectar los clicks.
            @Override
            public void onClick(View view) {
                registrarse(view);
            }
        });
    }

 void iniciarSesion(View view){
        Intent inicioSesion = new Intent(getApplicationContext(), IniciarSesion.class); //Metodo para cambiar de actividad a otra
        startActivity(inicioSesion); //Metodo para iniciar la Ac
    }

    public void registrarse(View view){
        Intent registro = new Intent(getApplicationContext(), Registro.class);
        startActivity(registro);
    }

    private void inicialize(){
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            Intent intent = new Intent(getApplicationContext(), BarraNavegacion.class);
            startActivity(intent);
            finish();
        } else {
        }
    }
}