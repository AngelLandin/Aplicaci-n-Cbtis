package cbtis.app.aplicacionCbtis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cbtis.app.aplicacionCbtis.databinding.ActivityIniciarSesionBinding;

public class IniciarSesión extends AppCompatActivity {

    private ActivityIniciarSesionBinding binding;
    private TextInputEditText email;
    private TextInputEditText contrasena;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIniciarSesionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        email = binding.campoEmail;
        contrasena = binding.campoContrasena;
        mAuth = FirebaseAuth.getInstance();//Obtenemos una instacia de FireBase

        Intent intent = new Intent(IniciarSesión.this, BarraNavegacion.class);

        binding.btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion(view);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    //Método para iniciar Sesion un usuario
    public void iniciarSesion(View view){
        mAuth.signInWithEmailAndPassword(email.getText().toString().trim(), contrasena.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Auntenticación correcta", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), BarraNavegacion.class);
                            startActivity(intent);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Auntenticación fallida.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }
}