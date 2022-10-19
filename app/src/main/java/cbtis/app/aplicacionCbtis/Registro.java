package cbtis.app.aplicacionCbtis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cbtis.app.aplicacionCbtis.databinding.ActivityIniciarSesionBinding;
import cbtis.app.aplicacionCbtis.databinding.ActivityInterfazRegistroBinding;

public class Registro extends AppCompatActivity {

    private ActivityInterfazRegistroBinding binding;
    private TextInputEditText email;
    private TextInputEditText contrasena;
    private TextInputEditText contrasenaConfirmar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInterfazRegistroBinding.inflate(getLayoutInflater());
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        setContentView(binding.getRoot());
        email = binding.email;
        contrasena = binding.contrasena;
        contrasenaConfirmar = binding.confirmarContrasena;

        binding.btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario(view);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        /* if(currentUser != null){
            reload();
        } */
    }

    public void registrarUsuario(View view){
        if(contrasena.getText().toString().equals(contrasenaConfirmar.getText().toString())){
            mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(), contrasena.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(), "Usuario creado",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), BarraNavegacion.class);
                                startActivity(intent);
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(), "No se logro autentica al usuario",Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }});
        }

        else {
            Toast.makeText(this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
        }
    }

    public void crearCuenta(String email, String password) {
        // [START create_user_with_email]
    }
}