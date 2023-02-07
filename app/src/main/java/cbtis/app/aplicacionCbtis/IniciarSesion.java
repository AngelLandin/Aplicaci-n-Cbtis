package cbtis.app.aplicacionCbtis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cbtis.app.aplicacionCbtis.databinding.ActivityIniciarSesionBinding;

public class IniciarSesion extends AppCompatActivity {

    private ActivityIniciarSesionBinding binding;
    private TextInputEditText email;
    private TextInputEditText contrasena;
    private FirebaseAuth firebaseAuth;
    private Context context;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIniciarSesionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.context = getApplicationContext();

        email = binding.campoEmail;
        contrasena = binding.campoContrasena;
        firebaseAuth = FirebaseAuth.getInstance();//Obtenemos una instacia de FireBase

        Intent intent = new Intent(IniciarSesion.this, BarraNavegacion.class);

        binding.btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingrese un email", Toast.LENGTH_LONG).show();
                }
                if(contrasena.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingrese su contraseña", Toast.LENGTH_LONG).show();
                }
                else{
                    iniciarSesion(view);
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
    }

    //Método para iniciar Sesion un usuario
    public void iniciarSesion(View view){
        firebaseAuth.signInWithEmailAndPassword(email.getText().toString().trim(), contrasena.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Auntenticación correcta", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), BarraNavegacion.class);
                            startActivity(intent);
                            finish();
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