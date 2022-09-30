package cbtis.app.aplicacionCbtis;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cbtis.app.aplicacionCbtis.databinding.ActivityBarraNavegacionBinding;
import cbtis.app.aplicacionCbtis.ui.comunidad.ComunidadFragment;
import cbtis.app.aplicacionCbtis.ui.configuraciones.ConfiguracionesFragment;
import cbtis.app.aplicacionCbtis.ui.home.HogarFragment;
import cbtis.app.aplicacionCbtis.ui.cursos.CursosFragment;

public class BarraNavegacion extends AppCompatActivity {

    private ActivityBarraNavegacionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityBarraNavegacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        remplazarFragment(new cbtis.app.aplicacionCbtis.PrincipalFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.principal:
                    remplazarFragment(new cbtis.app.aplicacionCbtis.PrincipalFragment());
                    break;
                case R.id.comunidad:
                    remplazarFragment(new ComunidadFragment());
                    break;
                case R.id.cursos:
                    remplazarFragment(new CursosFragment());
                    break;
                case R.id.configuraciones:
                    remplazarFragment(new ConfiguracionesFragment());
                    break;
                case R.id.hogar:
                    remplazarFragment(new HogarFragment());
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
