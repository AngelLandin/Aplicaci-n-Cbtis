package cbtis.app.aplicacionCbtis.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import cbtis.app.aplicacionCbtis.BotonesDeRegistro;
import cbtis.app.aplicacionCbtis.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, BotonesDeRegistro.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}