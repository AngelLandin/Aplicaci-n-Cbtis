package cbtis.app.aplicacionCbtis;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import cbtis.app.aplicacionCbtis.databinding.ActivityBotonesDeRegistroBinding;

public class BotonesDeRegistro extends AppCompatActivity {
    private ActivityBotonesDeRegistroBinding binding;
    private FirebaseAuth firebaseAuth; //Instancia de Firebase para la autenticacion de Usuario
    private Button btnIniciarSesion; //Boton Iniciar Sesion
    private Button btnRegistrarse; //Boton Registrarse
    private Button googleAuth; //Botn de registro con Google
    private FirebaseDatabase dataBase;
    private Button buttonInvitado;
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SING_IN = 9001;
    private static final String TAG = "GoogleActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBotonesDeRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicialize();
        this.btnIniciarSesion = binding.btnIniciarSesion; //Llamamos a nuestro boton Iniciar Sesion
        this.btnRegistrarse = binding.btnregistrarse; //Llamamos a nuestro Boton Registrar
        this.googleAuth = binding.googleButton; //Llamamos a nuestro Boton de Registro con Google
        this.buttonInvitado = binding.bottonInvitado; //Llamamos a nuestro Boton de invitado

        this.firebaseAuth = FirebaseAuth.getInstance();
        this.dataBase = FirebaseDatabase.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        this.googleAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSingIn();
            }
        });

        if(firebaseAuth.getCurrentUser() != null){
            Intent intent = new Intent(BotonesDeRegistro.this, BarraNavegacion.class);
            startActivity(intent);
            finish();
        }

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

        buttonInvitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BarraNavegacion.class);
                startActivity(intent);
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
        }
    }

    public void googleSingIn() {
        Intent intent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(intent, RC_SING_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RC_SING_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try{
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "FirebaseAuthWithGoogle" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());

            }
            catch (ApiException e){
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }

    public void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI(user);
                            Intent intent = new Intent(BotonesDeRegistro.this, BarraNavegacion.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Log.w(TAG, "signInWithCredential:Failure", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }

    private void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SING_IN);
    }
    
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }
}