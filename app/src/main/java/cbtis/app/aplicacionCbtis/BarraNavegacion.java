package cbtis.app.aplicacionCbtis;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cbtis.app.aplicacionCbtis.databinding.ActivityBarraNavegacionBinding;
import cbtis.app.aplicacionCbtis.ui.configuraciones.ConfiguracionesFragment;
import cbtis.app.aplicacionCbtis.ui.cursos.CursosFragment;
import cbtis.app.aplicacionCbtis.ui.noticias.NoticiasFragment;
import cbtis.app.aplicacionCbtis.PrincipalFragment;

public class BarraNavegacion extends AppCompatActivity {

    private ActivityBarraNavegacionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityBarraNavegacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        remplazarFragment(new PrincipalFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.principal:
                    remplazarFragment(new PrincipalFragment());
                    break;
                case R.id.cursos:
                    remplazarFragment(new CursosFragment());
                    break;
                case R.id.noticias:
                    remplazarFragment(new NoticiasFragment());
                    break;
                case R.id.configuraciones:
                    remplazarFragment(new ConfiguracionesFragment());
                    break;
            }
            return true;
        });
    }

    private void remplazarFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
